package com.example.coursemanagement.service;

import com.example.coursemanagement.dto.StudentCreateRequest;
import com.example.coursemanagement.model.Student;
import com.example.coursemanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void createStudent(StudentCreateRequest req) {
        Student student = new Student();
        student.setName(req.getName());
        student.setEmail(req.getEmail());
        studentRepository.save(student);
    }
}