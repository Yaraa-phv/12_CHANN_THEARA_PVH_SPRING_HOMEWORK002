package com.example.springhw002.controller;

import com.example.springhw002.model.dto.request.CourseRequest;
import com.example.springhw002.model.dto.response.ApiResponse;
import com.example.springhw002.model.entity.Courses;
import com.example.springhw002.model.entity.Instructors;
import com.example.springhw002.service.CoursesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@Tag(name = "Courses Controller")
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Courses>>> getAllCourses(){
        ApiResponse<List<Courses>> response = ApiResponse.<List<Courses>> builder()
                .message("Get All Courses Successfully")
                .payload(coursesService.getAllCourses())
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Courses>> addCourse(@RequestBody CourseRequest courseRequest){
        ApiResponse<Courses> response = ApiResponse.<Courses> builder()
                .message("Add A Course Successfully")
                .payload(coursesService.addCourse(courseRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> getCourseByID(@PathVariable Integer id){
        ApiResponse<Courses> response = ApiResponse.<Courses> builder()
                .message("Get A Course Successfully")
                .payload(coursesService.getCourseByID(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> updateCourseByID(@PathVariable Integer id, @RequestBody CourseRequest courseRequest){
        ApiResponse<Courses> response = ApiResponse.<Courses> builder()
                .message("Update A Course Successfully")
                .payload(coursesService.updateCourseByID(id, courseRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> deleteCourseByID(@PathVariable Integer id){
        ApiResponse<Courses> response = ApiResponse.<Courses> builder()
                .message("Update A Course Successfully")
                .payload(coursesService.deleteCourseByID(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
