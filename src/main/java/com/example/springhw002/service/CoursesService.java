package com.example.springhw002.service;

import com.example.springhw002.model.dto.request.CourseRequest;
import com.example.springhw002.model.entity.Courses;

import java.util.List;

public interface CoursesService {
    List<Courses> getAllCourses();
    Courses addCourse(CourseRequest courseRequest);
    Courses getCourseByID(Integer id);
    Courses updateCourseByID(Integer id, CourseRequest courseRequest);
    Courses deleteCourseByID(Integer id);
}
