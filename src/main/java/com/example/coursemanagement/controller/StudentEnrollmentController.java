package com.example.coursemanagement.controller;

import com.example.coursemanagement.dto.ApiResponse;
import com.example.coursemanagement.dto.StudentEnrollmentRequest;
import com.example.coursemanagement.service.StudentEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/enrollments")
@RequiredArgsConstructor
public class StudentEnrollmentController {

    private final StudentEnrollmentService studentEnrollmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> enrollStudent(@RequestBody StudentEnrollmentRequest req) {
        studentEnrollmentService.enrollStudent(req.getStudentId(), req.getCourseId());
        return ResponseEntity.ok(new ApiResponse<>("Student Enrolled Successfully", true, null));
    }
}