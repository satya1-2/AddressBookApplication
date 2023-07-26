package com.example.addressbook.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class ContactDetailsDTO {
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "contactDetails Name invalid")
    public String name;

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Contact details State invalid")
    public String state;

    @NotEmpty
    public String address;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "email are not matching invalid")
    public String email;

    @Pattern(regexp = "^(?:(?:\\+91)|(?:91)|(?:0))[7-9][0-9]{9}$", message = "mobile number invalid this is not indian mobile number")
    public String phoneNumber;


    @NotBlank(message = " City can not be empty")
    public String city;

    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$",message="pin number invalid for India ")
      public String pinNumber;
}


