package com.example.StudentManagementSystem.Service;

import com.example.StudentManagementSystem.DTO.StudentRequestDTO;
import com.example.StudentManagementSystem.DTO.StudentResponseDTO;
import com.example.StudentManagementSystem.DTO.UpdateDTO;
import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.Exception.StudentNotFoundException;
import com.example.StudentManagementSystem.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class Studentservice {

    private StudentRepo studentrepo;
    public Studentservice(StudentRepo studentrepo) {
        this.studentrepo = studentrepo;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Page<StudentResponseDTO> findAll(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<Student> studentPage = studentrepo.findAll(pageable);

        return studentPage.map(student -> {
            StudentResponseDTO dto = new StudentResponseDTO();
            dto.setId(student.getId());
            dto.setEmail(student.getEmail());
            dto.setName(student.getName());
            dto.setAge(student.getAge());
            return dto;
        });
    }
    public StudentResponseDTO findById(Long id) {
        Student s=studentrepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
        StudentResponseDTO dto=new StudentResponseDTO();
        dto.setId(s.getId());
        dto.setName(s.getName());
        dto.setEmail(s.getEmail());
        dto.setAge(s.getAge());
        return dto;
    }
    public StudentResponseDTO save(StudentRequestDTO model) {
        Student s=new Student();
        s.setName(model.getName());
        s.setEmail(model.getEmail());
        s.setAge(model.getAge());
        s.setPassword(model.getPassword());
        Student saved = studentrepo.save(s);
        StudentResponseDTO dto=new StudentResponseDTO();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setEmail(saved.getEmail());
        dto.setAge(saved.getAge());
        return dto;
    }
    public void deleteById(Long id) {
        if(!studentrepo.existsById(id)){
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        studentrepo.deleteById(id);
    }
    public void deleteall() {
        studentrepo.deleteAll();
    }
    public StudentResponseDTO update(Long id, UpdateDTO mod) {
        Student s=studentrepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
        s.setName(mod.getName());
        s.setEmail(mod.getEmail());
        s.setAge(mod.getAge());
        Student saved=studentrepo.save(s);
        StudentResponseDTO dto=new StudentResponseDTO();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setEmail(saved.getEmail());
        dto.setAge(saved.getAge());
        return dto;
    }
}
