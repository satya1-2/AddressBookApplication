package com.example.addressbook.service;

import com.example.addressbook.dto.ContactDetailsDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.model.ContactDetails;

import java.util.List;

public interface ContactsDetailsService {
    ResponseDTO addContactDetails(ContactDetailsDTO contactDetailsDTO );

    ContactDetails updateContactDetails(String token,  ContactDetailsDTO contactDetailsDTO );

    void deleteContactDetails(String token );

    void deleteAllContactDetails();

    ContactDetails getContactDetailsById(String token);

    List<ContactDetails> getAllContactDetails();

}
