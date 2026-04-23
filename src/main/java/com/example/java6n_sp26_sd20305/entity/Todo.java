package com.example.java6n_sp26_sd20305.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "todos")
public class Todo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;


        @Size(min = 3, max = 50 , message = "Title must be between 3 and 50 characters")
    private String title;

        @Size(min = 3, message = "Description must be at least 3 characters")
    private String description;

    private Boolean completed;




}
