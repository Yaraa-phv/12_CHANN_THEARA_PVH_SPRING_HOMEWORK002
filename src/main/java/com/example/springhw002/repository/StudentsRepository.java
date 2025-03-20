package com.example.springhw002.repository;

import com.example.springhw002.model.dto.request.StudentRequest;
import com.example.springhw002.model.entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentsRepository {

    @Select("""
        SELECT * FROM students
    """)
    @Results(id = "studentsMapper", value = {
            @Result(property = "id", column = "student_id"),
            @Result(property = "name", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    many = @Many(select = "com.example.springhw002.repository.CoursesRepository.getCourseByStudentID"))
    })
    List<Students> getAllStudents();


    @Select("""
        SELECT * FROM students
        WHERE student_id = #{id}
    """)
    @ResultMap("studentsMapper")
    Students getStudentByID(Integer id);

    @Select("""
        INSERT INTO students(student_name, email, phone_number) 
        VALUES (#{add.name}, #{add.email}, #{add.phoneNumber})
        RETURNING *
    """)
    @ResultMap("studentsMapper")
    Students addStudent(@Param("add")StudentRequest studentRequest);

    @Select("""
        UPDATE students 
        SET student_name = #{update.name}, email = #{update.email}, phone_number = #{update.phoneNumber}
        WHERE student_id = #{id}
        RETURNING *
    """)
    @ResultMap("studentsMapper")
    Students updateStudentByID(Integer id, @Param("update") StudentRequest studentRequest);


    @Select("""
        DELETE FROM students 
        WHERE student_id = #{id}
    """)
    @ResultMap("studentsMapper")
    Students deleteStudentByID(Integer id);

}
