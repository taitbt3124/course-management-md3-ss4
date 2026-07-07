package com.example.coursemanagement.controller;

import com.example.coursemanagement.dto.ApiResponse;
import com.example.coursemanagement.dto.CourseCreateRequest;
import com.example.coursemanagement.dto.CourseUpdateRequest;
import com.example.coursemanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createCourse(@RequestBody CourseCreateRequest req) {
        courseService.createCourse(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Course Created Successfully", true, null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateCourse(@PathVariable Long id, @RequestBody CourseUpdateRequest req) {
        courseService.updateCourse(id, req);
        return ResponseEntity.ok(new ApiResponse<>("Course Updated Successfully", true, null));
    }
}