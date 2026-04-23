package com.example.java6n_sp26_sd20305.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class CustomErrorDetails {

    private LocalDateTime timestamp;

    private String message;

    private String details;





}
