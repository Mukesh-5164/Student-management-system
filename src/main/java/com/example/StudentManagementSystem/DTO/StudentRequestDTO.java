package com.example.StudentManagementSystem.DTO;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class StudentRequestDTO {
    @NotBlank(message = "Name is needed")
    private String name;
   @NotBlank(message = "Password is required")
   @Size(min = 6, max = 16, message = "Must be 6 min and 16 max")
    private String password;
    @Email(message = "Invaild email")
    @NotBlank(message = "Email is needed")
    private String email;
    @Min(value=1,message = "Age must")
    @Max(value=100,message = "Must be less than 100")
    private int age;
}
