package com.example.addressbook.service;

import com.example.addressbook.dto.ContactDetailsDTO;
import com.example.addressbook.model.ContactDetails;

import java.util.List;

public interface ContactsDetailsService {
    ContactDetails addContactDetails(ContactDetailsDTO contactDetailsDTO );

    ContactDetails updateContactDetails(int id,  ContactDetailsDTO contactDetailsDTO );

    void deleteContactDetails(int id);

    void deleteAllContactDetails();

    ContactDetails getContactDetailsById(int id);

    List<ContactDetails> getAllContactDetails();

}
