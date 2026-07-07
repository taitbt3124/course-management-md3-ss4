package com.example.coursemanagement.service;

import com.example.coursemanagement.dto.CourseCreateRequest;
import com.example.coursemanagement.dto.CourseUpdateRequest;
import com.example.coursemanagement.model.Course;
import com.example.coursemanagement.model.Instructor;
import com.example.coursemanagement.repository.CourseRepository;
import com.example.coursemanagement.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public void createCourse(CourseCreateRequest req) {
        Instructor instructor = instructorRepository.findById(req.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên ID: " + req.getInstructorId()));

        Course course = new Course();
        course.setTitle(req.getTitle());
        course.setStatus(req.getStatus());
        course.setInstructor(instructor);

        courseRepository.save(course);
    }

    public void updateCourse(Long id, CourseUpdateRequest req) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học ID: " + id));

        Instructor instructor = instructorRepository.findById(req.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên ID: " + req.getInstructorId()));

        course.setTitle(req.getTitle());
        course.setStatus(req.getStatus());
        course.setInstructor(instructor);
        
        courseRepository.save(course);
    }
}