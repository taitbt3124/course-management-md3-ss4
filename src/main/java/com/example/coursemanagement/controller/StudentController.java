package com.example.coursemanagement.controller;

import com.example.coursemanagement.dto.ApiResponse;
import com.example.coursemanagement.dto.StudentCreateRequest;
import com.example.coursemanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createStudent(@RequestBody StudentCreateRequest req) {
        studentService.createStudent(req);
        return ResponseEntity.ok(new ApiResponse<>("Student Created Successfully", true, null));
    }
}