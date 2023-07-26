package com.example.addressbook.service;

import com.example.addressbook.dto.ContactDetailsDTO;
import com.example.addressbook.exception.ContactCustomException;
import com.example.addressbook.model.ContactDetails;
import com.example.addressbook.repo.ContactDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ContactDetailsService implements ContactsDetailsService {
    @Autowired
    private ContactDetailsRepo contactDetailsRepo;

    public ContactDetails addContactDetails(ContactDetailsDTO contactDetailsDTO) {
        ContactDetails contactDetailsData = new ContactDetails(contactDetailsDTO);
        return contactDetailsRepo.save(contactDetailsData);
    }

    public ContactDetails updateContactDetails(int id, ContactDetailsDTO contactDetailsDTO) {
        ContactDetails contactDetailsData = getContactDetailsById(id);
        if (contactDetailsData == null) {
            throw new IllegalArgumentException("contact details not found with ID: " + id);
        }
        contactDetailsData.updateContactDetails(contactDetailsDTO);
        return contactDetailsRepo.save(contactDetailsData);
    }

    public void deleteContactDetails(int id) {
        ContactDetails contactDetailsData = getContactDetailsById(id);
        if (contactDetailsData == null) {
            throw new IllegalArgumentException("Contact details not found with ID: " + id);
        }

        contactDetailsRepo.deleteById(id);
    }

    public void deleteAllContactDetails() {

        contactDetailsRepo.deleteAll();
    }

    public ContactDetails getContactDetailsById(int id) {

        return contactDetailsRepo.findById(id).orElseThrow(() -> new ContactCustomException("contact details with id: " + id + "not present"));
    }

    public List<ContactDetails> getAllContactDetails() {

        return contactDetailsRepo.findAll();
    }
}


