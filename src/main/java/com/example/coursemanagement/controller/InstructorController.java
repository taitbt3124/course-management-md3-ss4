package com.example.coursemanagement.controller;

import com.example.coursemanagement.dto.ApiResponse;
import com.example.coursemanagement.dto.InstructorCreateRequest;
import com.example.coursemanagement.model.Instructor;
import com.example.coursemanagement.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody InstructorCreateRequest req) {
        Instructor savedInstructor = instructorService.createInstructor(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Ok", true, savedInstructor));
    }
}