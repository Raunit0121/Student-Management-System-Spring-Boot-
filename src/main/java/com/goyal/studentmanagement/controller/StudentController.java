package com.goyal.studentmanagement.controller;

import com.goyal.studentmanagement.dto.StudentDTO;
import com.goyal.studentmanagement.service.StudentService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ➕ Add
    @PostMapping
    public StudentDTO addStudent(@Valid @RequestBody StudentDTO dto) {
        return service.saveStudent(dto);
    }

    // 📄 Get All
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return service.getAllStudents();
    }

    // 🔍 Get One
    @GetMapping("/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    // 🔁 Update
    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
        return service.updateStudent(id, dto);
    }

    // ❌ Delete
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
}