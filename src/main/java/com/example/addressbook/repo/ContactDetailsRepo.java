package com.example.addressbook.repo;

import com.example.addressbook.model.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface ContactDetailsRepo extends JpaRepository<ContactDetails, Integer> {
       // boolean existsByEmail(String gmail);


    }

