package com.example.addressbook.controller;

import com.example.addressbook.dto.ContactDetailsDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.model.ContactDetails;
import com.example.addressbook.service.ContactDetailsService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactDetails")
@Slf4j
public class AddressBookController {

    @Autowired
    private ContactDetailsService contactDetailsService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addContactDetails(@Valid @RequestBody ContactDetailsDTO contactDetailsDTO) {
        log.debug("Adding contact details: {}", contactDetailsDTO);
        ContactDetails contactDetails = contactDetailsService.addContactDetails(contactDetailsDTO);
        log.info("Contact details added successfully: {}", contactDetails);
        ResponseDTO responseDTO = new ResponseDTO("Data added Successfully", contactDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);


    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable int id, @Valid @RequestBody ContactDetailsDTO contactDetailsDTO) {
        log.debug("Updating conatct details with ID: {}", id);
        ContactDetails contactDetails = contactDetailsService.updateContactDetails(id, contactDetailsDTO);
        log.info("Contact Details updated successfully: {}", contactDetails);
        ResponseDTO responseDTO = new ResponseDTO("Data updated Successfully", contactDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContactDetails(@PathVariable int id) {
        log.debug("Deleting contact details with ID: {}", id);
        contactDetailsService.deleteContactDetails(id);
        log.info("contact details deleted successfully. ID: {}", id);
        ResponseDTO responseDTO = new ResponseDTO("Data deleted successfully", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @DeleteMapping("/delete/all")
    public ResponseEntity<ResponseDTO> deleteAllContactDetails() {
        log.debug("Deleting all contact details");
        contactDetailsService.deleteAllContactDetails();
        log.info("All contacts details  deleted successfully");
        ResponseDTO responseDTO = new ResponseDTO("All data deleted successfully", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getContactDetailsById(@PathVariable int id) {
        log.debug("Retrieving contact details by ID: {}", id);
        ContactDetails contactDetails = contactDetailsService.getContactDetailsById(id);
        ResponseDTO responseDTO;
        HttpStatus status;
        if (contactDetails != null) {
            log.info("Contact Details found. ID: {}", id);
            responseDTO = new ResponseDTO("contact details found", contactDetails);
            status = HttpStatus.OK;
        } else {
            log.warn("Contact details not found. ID: {}", id);
            responseDTO = new ResponseDTO("Contact details not found", null);
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(responseDTO, status);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllContactDetails() {
        log.debug("Retrieving all contact details");
        List<ContactDetails> contactDetails = contactDetailsService.getAllContactDetails();
        ResponseDTO responseDTO;
        HttpStatus status;
        if (!contactDetails.isEmpty()) {
            log.info("contact details found: {}", contactDetails.size());
            responseDTO = new ResponseDTO("Contact details found", contactDetails);
            status = HttpStatus.OK;
        } else {
            log.warn("No contact details found");
            responseDTO = new ResponseDTO("No contact details found", null);
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(responseDTO, status);
    }
}

