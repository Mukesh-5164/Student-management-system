package com.example.StudentManagementSystem.DTO;

import com.example.StudentManagementSystem.Entity.Student;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 6, max = 16, message = "Must be 6 min and 16 max")
    private String name;
    @Email(message = "Invaild email")
    @NotBlank(message = "Email is needed")
    private String email;
    @Min(value=1,message = "Age must")
    @Max(value=100,message = "Must be less than 100")
    private Integer age;
}
