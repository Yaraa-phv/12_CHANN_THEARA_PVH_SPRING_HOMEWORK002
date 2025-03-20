package com.example.springhw002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourses {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
}
