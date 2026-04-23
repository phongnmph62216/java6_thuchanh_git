package com.example.java6n_sp26_sd20305.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        private String author;

        private Double price;

        private String isbn;




}
