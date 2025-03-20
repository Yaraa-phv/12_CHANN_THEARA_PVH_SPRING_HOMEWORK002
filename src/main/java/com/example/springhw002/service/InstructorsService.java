package com.example.springhw002.service;

import com.example.springhw002.model.dto.request.InstructorRequest;
import com.example.springhw002.model.entity.Instructors;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface InstructorsService {
    List<Instructors> getAllInstructors();
    Instructors addInstructor(InstructorRequest instructorRequest);
    Instructors getInstructorByID(Integer id);
    Instructors updateInstructorByID(Integer id, InstructorRequest instructorRequest);
    Instructors deleteInstructorByID(Integer id);
}
