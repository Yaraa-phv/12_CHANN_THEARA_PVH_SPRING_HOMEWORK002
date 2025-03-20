package com.example.springhw002.model.dto.request;

import com.example.springhw002.model.entity.Courses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private List<Integer> courseId;
}