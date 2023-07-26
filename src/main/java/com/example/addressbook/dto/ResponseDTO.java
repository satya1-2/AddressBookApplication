package com.example.addressbook.dto;

import com.example.addressbook.model.ContactDetails;
import lombok.Data;

@Data
public class ResponseDTO {

    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}