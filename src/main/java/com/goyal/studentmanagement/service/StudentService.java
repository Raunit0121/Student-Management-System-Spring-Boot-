package com.goyal.studentmanagement.service;

import com.goyal.studentmanagement.dto.StudentDTO;
import com.goyal.studentmanagement.exception.ResourceNotFoundException;
import com.goyal.studentmanagement.model.Student;
import com.goyal.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // 🔁 Entity → DTO
    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
    }

    // 🔁 DTO → Entity (FIXED: no id)
    private Student mapToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        return student;
    }

    // ➕ Create
    public StudentDTO saveStudent(StudentDTO dto) {
        Student student = mapToEntity(dto);
        Student saved = repository.save(student);
        return mapToDTO(saved);
    }

    // 📄 Get All
    public List<StudentDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // 🔍 Get By ID
    public StudentDTO getStudentById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));

        return mapToDTO(student);
    }

    // 🔁 Update
    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        return mapToDTO(repository.save(student));
    }

    // ❌ Delete
    public void deleteStudent(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));

        repository.delete(student);
    }
}