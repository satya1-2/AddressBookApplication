package com.example.addressbook.exception;

import com.example.addressbook.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class ContactExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String>errMsg=errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO respdto=new ResponseDTO("exception while processing RESTAPI",errMsg);
        return new ResponseEntity<>(respdto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ContactCustomException.class)
    public ResponseEntity<ResponseDTO>handleContactCustomException(ContactCustomException exception){
        ResponseDTO respdto=new ResponseDTO("Exception while processing RESTAPI",exception.getMessage());
        return  new ResponseEntity<>(respdto,HttpStatus.BAD_REQUEST);
    }


}