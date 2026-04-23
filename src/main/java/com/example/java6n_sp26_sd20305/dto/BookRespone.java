package com.example.java6n_sp26_sd20305.dto;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRespone {

        private Long id;

         private String title;

        private String author;

        private Double price;

        private String isbn;



}
