package com.example.StudentManagementSystem.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @Email(message = "Invaild email")
    @NotBlank(message = "Email is needed")
    private String email;
    @NotBlank(message = "Name is needed")
    private String name;
    private String password;
}
