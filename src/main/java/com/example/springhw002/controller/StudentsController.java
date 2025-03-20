package com.example.springhw002.controller;

import com.example.springhw002.model.dto.request.StudentRequest;
import com.example.springhw002.model.dto.response.ApiResponse;
import com.example.springhw002.model.entity.Courses;
import com.example.springhw002.model.entity.Students;
import com.example.springhw002.service.StudentsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@Tag(name = "Student Controller")
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService){
        this.studentsService = studentsService;
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<Students>>> getAllStudents(@RequestParam Integer offset, @RequestParam Integer limit){
        ApiResponse<List<Students>> response = ApiResponse.<List<Students>> builder()
                .message("Get All Students Successfully")
                .payload(studentsService.getAllStudents(offset, limit))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Students>> getStudentByID(@PathVariable Integer id){
        ApiResponse<Students> response = ApiResponse.<Students> builder()
                .message("Get A Students Successfully")
                .payload(studentsService.getStudentByID(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Students>> addStudent(@RequestBody StudentRequest studentRequest){
        ApiResponse<Students> response = ApiResponse.<Students> builder()
                .message("Add A Students Successfully")
                .payload(studentsService.addStudent(studentRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Students>> updateStudentByID(@PathVariable Integer id, @RequestBody StudentRequest studentRequest){
        ApiResponse<Students> response = ApiResponse.<Students> builder()
                .message("Update A Students Successfully")
                .payload(studentsService.updateStudentByID(id, studentRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Students>> deleteStudentByID(@PathVariable Integer id){
        ApiResponse<Students> response = ApiResponse.<Students> builder()
                .message("Delete A Students Successfully")
                .payload(studentsService.deleteStudentByID(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
