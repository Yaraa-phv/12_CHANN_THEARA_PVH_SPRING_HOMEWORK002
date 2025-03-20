package com.example.springhw002.service;

import com.example.springhw002.model.dto.request.StudentRequest;
import com.example.springhw002.model.entity.Students;

import java.util.List;

public interface StudentsService {
    List<Students> getAllStudents();
    Students addStudent(StudentRequest studentRequest);
    Students getStudentByID(Integer id);
    Students updateStudentByID(Integer id, StudentRequest studentRequest);
    Students deleteStudentByID(Integer id);
}
