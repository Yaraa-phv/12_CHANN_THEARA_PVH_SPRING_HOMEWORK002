package com.example.springhw002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    private Integer id;
    private String name;
    private String description;
    private Instructors instructors;
}
