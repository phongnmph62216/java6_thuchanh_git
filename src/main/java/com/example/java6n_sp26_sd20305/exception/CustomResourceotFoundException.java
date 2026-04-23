package com.example.java6n_sp26_sd20305.exception;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomResourceotFoundException extends RuntimeException {

    public CustomResourceotFoundException(String message) {
        super(message);
    }




}
