package com.example.coursemanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEnrollmentRequest {
    private Long studentId;
    private Long courseId;
}