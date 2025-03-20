package com.example.springhw002.service.Impl;

import com.example.springhw002.model.dto.request.StudentRequest;
import com.example.springhw002.model.entity.Students;
import com.example.springhw002.repository.CoursesRepository;
import com.example.springhw002.repository.StudentsRepository;
import com.example.springhw002.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;
    private final CoursesRepository coursesRepository;


    public StudentsServiceImpl(StudentsRepository studentsRepository, CoursesRepository coursesRepository){
        this.studentsRepository = studentsRepository;
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.getAllStudents();
    }

    @Override
    public Students addStudent(StudentRequest studentRequest) {

        Students students = studentsRepository.addStudent(studentRequest);
        for (Integer courseId : studentRequest.getCourseId()){
            coursesRepository.addStudentCourse(students.getId(), courseId);
        }
        System.out.println(studentRequest.getCourseId());

        return studentsRepository.getStudentByID(students.getId());
    }

    @Override
    public Students getStudentByID(Integer id) {
        return studentsRepository.getStudentByID(id);
    }

    @Override
    public Students updateStudentByID(Integer id, StudentRequest studentRequest) {
        Students students = studentsRepository.updateStudentByID(id, studentRequest);
        coursesRepository.deleteStudentCourse(students.getId());
        for (Integer courseId : studentRequest.getCourseId()){
            coursesRepository.addStudentCourse(students.getId(), courseId);
        }
        return studentsRepository.getStudentByID(students.getId());
    }

    @Override
    public Students deleteStudentByID(Integer id) {
        coursesRepository.deleteStudentCourse(id);
//        Students students = studentsRepository.deleteStudentByID(id);
        return studentsRepository.deleteStudentByID(id);
    }
}
