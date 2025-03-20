package com.example.springhw002.controller;

import com.example.springhw002.model.dto.request.InstructorRequest;
import com.example.springhw002.model.dto.response.ApiResponse;
import com.example.springhw002.model.entity.Instructors;
import com.example.springhw002.service.InstructorsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
@Tag(name = "Instructor Controller")
public class InstructorsController {

    private final InstructorsService instructorsService;

    public InstructorsController(InstructorsService instructorsService){
        this.instructorsService = instructorsService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructors>>> getAllInstructors(@RequestParam Integer offset, @RequestParam Integer limit){
        ApiResponse<List<Instructors>> response = ApiResponse.<List<Instructors>> builder()
                .message("Get All Instructors Successfully")
                .payload(instructorsService.getAllInstructors(offset, limit))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        System.out.println(response);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructors>> addInstructor(@RequestBody InstructorRequest instructorRequest){
        ApiResponse<Instructors> response = ApiResponse.<Instructors> builder()
                .message("Add An Instructor Successfully")
                .payload(instructorsService.addInstructor(instructorRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> getInstructorById(@PathVariable Integer id){
        ApiResponse<Instructors> response = ApiResponse.<Instructors> builder()
                .message("Get An Instructor Successfully")
                .payload(instructorsService.getInstructorByID(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> updateInstructorByID(@PathVariable Integer id, @RequestBody InstructorRequest instructorRequest){
        ApiResponse<Instructors> response = ApiResponse.<Instructors> builder()
                .message("Update An Instructor Successfully")
                .payload(instructorsService.updateInstructorByID(id, instructorRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> deleteInstructorByID(@PathVariable Integer id){
        ApiResponse<Instructors> response = ApiResponse.<Instructors> builder()
                .message("Delete An Instructor Successfully")
                .payload(instructorsService.deleteInstructorByID(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
