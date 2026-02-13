package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.DTO.StudentRequestDTO;
import com.example.StudentManagementSystem.DTO.StudentResponseDTO;
import com.example.StudentManagementSystem.DTO.UpdateDTO;

import com.example.StudentManagementSystem.Service.Studentservice;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/detail")
@CrossOrigin("http://localhost:3000")
public class Studentcontoller {

    private Studentservice service;
    public Studentcontoller(Studentservice service){
        this.service = service;
    }
    @GetMapping("/students")
    public Page<StudentResponseDTO> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return service.findAll(page, size, sortBy);
    }
    @GetMapping("/{id}")
    public StudentResponseDTO findOne(@PathVariable Long id) {
        return service.findById(id);
    }
    @PostMapping
    public StudentResponseDTO save(@Valid @RequestBody StudentRequestDTO model) {
        return service.save(model);
    }
    @PutMapping("/{id}")
    public StudentResponseDTO save(@PathVariable Long id,@Valid @RequestBody UpdateDTO student) {
        return service.update(id, student);
    }
    @DeleteMapping
    public void deleteal() {
        service.deleteall();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
