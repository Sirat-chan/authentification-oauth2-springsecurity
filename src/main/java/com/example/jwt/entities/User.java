package com.example.jwt.entities;


import com.example.jwt.entities.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profileImage;
    @Enumerated(EnumType.STRING)
    private Role role;


    public User() {
    }
}
