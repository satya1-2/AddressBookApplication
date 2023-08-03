package com.example.addressbook.service;

import com.example.addressbook.dto.ContactDetailsDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.exception.ContactCustomException;
import com.example.addressbook.model.ContactDetails;
import com.example.addressbook.repo.ContactDetailsRepo;
import com.example.addressbook.token.EmailService;
import com.example.addressbook.token.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDetailsService implements ContactsDetailsService {
    @Autowired
    private ContactDetailsRepo contactDetailsRepo;
    @Autowired
    private JWTToken jwtToken;
    @Autowired
    private EmailService contactDetailsServices;

    public ResponseDTO addContactDetails(ContactDetailsDTO contactDetailsDTO) {
        ContactDetails contactDetailsData = new ContactDetails(contactDetailsDTO);
        contactDetailsRepo.save(contactDetailsData);
        String token = jwtToken.createToken(contactDetailsData.getId());
        contactDetailsServices.sendEmail(contactDetailsDTO.getEmail(), "data added successfully",
                "hai " + contactDetailsDTO.getName() + "\n you have been successfully added data:\n\n" + contactDetailsData);
        return new ResponseDTO(token, contactDetailsData);

    }

    public ContactDetails updateContactDetails(String token, ContactDetailsDTO contactDetailsDTO) {
        ContactDetails contactDetailsData = getContactDetailsById(token);
        if (contactDetailsData == null) {
            throw new IllegalArgumentException("contact details not found with ID: " + token);
        }
        contactDetailsData.updateContactDetails(contactDetailsDTO);
        return contactDetailsRepo.save(contactDetailsData);
    }

    public void deleteContactDetails(String token) {
        ContactDetails contactDetailsData = getContactDetailsById(token);
        if (contactDetailsData == null) {
            throw new IllegalArgumentException("Contact details not found with ID: " + token);
        }
        contactDetailsRepo.deleteById(Integer.valueOf(token));
    }

    public void deleteAllContactDetails() {
        contactDetailsRepo.deleteAll();
    }

    public ContactDetails getContactDetailsById(String token) {
        int id = jwtToken.decodeToken(token);
        return contactDetailsRepo.findById(id).orElseThrow(() -> new ContactCustomException("contact details with id: " + id + "not present"));
    }

    public List<ContactDetails> getAllContactDetails() {
        return contactDetailsRepo.findAll();
    }
}


