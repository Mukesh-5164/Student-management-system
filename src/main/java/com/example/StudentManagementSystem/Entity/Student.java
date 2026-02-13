package com.example.StudentManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private int age;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
