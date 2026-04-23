package com.example.java6n_sp26_sd20305.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")

public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;


        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;


        @Column(nullable = false, unique = true)
        private String email;




        @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
        @JoinTable(
                name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
        )
        private Set<Role> roles = new HashSet<>();



}
