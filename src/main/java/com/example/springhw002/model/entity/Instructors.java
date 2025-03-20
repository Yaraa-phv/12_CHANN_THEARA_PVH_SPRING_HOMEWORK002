package com.example.springhw002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Instructors {
    private Integer id;
    private String name;
    private String email;
}
