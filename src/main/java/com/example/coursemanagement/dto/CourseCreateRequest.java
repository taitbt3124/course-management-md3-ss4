package com.example.coursemanagement.dto;

import com.example.coursemanagement.model.CourseStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;
}