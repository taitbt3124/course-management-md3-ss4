package com.example.coursemanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateRequest {
    private String name;
    private String email;
}