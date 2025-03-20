package com.example.springhw002.service.Impl;

import com.example.springhw002.model.dto.request.CourseRequest;
import com.example.springhw002.model.entity.Courses;
import com.example.springhw002.repository.CoursesRepository;
import com.example.springhw002.service.CoursesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;

    public CoursesServiceImpl(CoursesRepository coursesRepository){
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.getAllCourses();
    }

    @Override
    public Courses addCourse(CourseRequest courseRequest) {
        return coursesRepository.addCourse(courseRequest);
    }

    @Override
    public Courses getCourseByID(Integer id) {
        return coursesRepository.getCourseByID(id);
    }

    @Override
    public Courses updateCourseByID(Integer id, CourseRequest courseRequest) {
        return coursesRepository.updateCourseByID(id, courseRequest);
    }

    @Override
    public Courses deleteCourseByID(Integer id) {
        return coursesRepository.deleteCourseByID(id);
    }
}
