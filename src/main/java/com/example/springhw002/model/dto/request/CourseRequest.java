package com.example.springhw002.model.dto.request;

import com.example.springhw002.model.entity.Instructors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequest {
    private String name;
    private String description;
    private Integer instructorId;
}
