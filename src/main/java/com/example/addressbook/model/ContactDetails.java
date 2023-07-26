package com.example.addressbook.model;

import com.example.addressbook.dto.ContactDetailsDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "addressBook")
@Data
public class ContactDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private int id;
        @Column(name = "firstName")
        private String name;

        @Column(name = "contact_email")
        private String email;
        @Column(name = "Contact_phoneNumber")
        private String phoneNumber;
        @Column(name = "Contact_address")
        private String address;

        @Column(name = "Contacr_state")
        private String state;

        @Column(name = "Contact_city")
        private String city;
        private String pinNumber;
        public ContactDetails(ContactDetailsDTO contactDetailsDTO) {
            this.updateContactDetails(contactDetailsDTO);
        }

        public void updateContactDetails(ContactDetailsDTO contactDetailsDTO) {
            this.name = contactDetailsDTO.getName();
            this.email = contactDetailsDTO.getEmail();
            this.phoneNumber = contactDetailsDTO.getPhoneNumber();
            this.address = contactDetailsDTO.getAddress();
            this.state = contactDetailsDTO.getState();
            this.city = contactDetailsDTO.getCity();
            this.pinNumber = contactDetailsDTO.getPinNumber();

        }

    }

