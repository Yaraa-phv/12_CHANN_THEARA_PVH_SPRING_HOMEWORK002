package com.example.springhw002.repository;

import com.example.springhw002.model.dto.request.CourseRequest;
import com.example.springhw002.model.entity.Courses;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CoursesRepository {

    @Select("""
        SELECT * FROM courses
                 ORDER BY course_id
        OFFSET #{offset}
        LIMIT #{limit}
        
    """)
    @Results(id = "coursesMapper", value = {
            @Result(property = "id", column = "course_id"),
            @Result(property = "name", column = "course_name"),
            @Result(property = "instructors", column = "instructor_id",
                    one = @One(select = "com.example.springhw002.repository.InstructorsRepository.getInstructorByID"))
    })
    List<Courses> getAllCourses(Integer offset, Integer limit);

    @Select("""
        INSERT INTO courses(course_name, description, instructor_id)
        VALUES (#{add.name}, #{add.description}, #{add.instructorId})
        RETURNING * 
    """)
    @ResultMap("coursesMapper")
    Courses addCourse(@Param("add") CourseRequest courseRequest);

    @Select("""
        SELECT * FROM courses
        WHERE course_id = #{id}
    """)
    @ResultMap("coursesMapper")
    Courses getCourseByID(Integer id);


    @Select("""
        UPDATE courses
        SET course_name = #{update.name}, description = #{update.description}, instructor_id = #{update.instructorId}
        WHERE course_id = #{id}
        RETURNING * 
    """)
    @ResultMap("coursesMapper")
    Courses updateCourseByID(Integer id, @Param("update") CourseRequest courseRequest);

    @Select("""
        DELETE FROM courses
        WHERE course_id = #{id}
        RETURNING *
    """)
    @ResultMap("coursesMapper")
    Courses deleteCourseByID(Integer id);

    @Select("""
        SELECT c.course_id, c.course_name, c.description, c.instructor_id FROM courses c 
        INNER JOIN student_course sc ON c.course_id = sc.course_id
        WHERE student_id = #{studentId}
    """)
    @ResultMap("coursesMapper")
    @Result(property = "studentId", column = "student_id")
    List<Courses> getCourseByStudentID(Integer studentId);

    @Insert("""
        INSERT INTO student_course(student_id, course_id) 
        VALUES (#{studentId}, #{courseId})
        RETURNING *
    """)
    void addStudentCourse(Integer studentId, Integer courseId);

    @Update("""
        UPDATE student_course
        SET course_id = #{courseId}
        WHERE student_id = #{studentId} 
    """)
    void updateStudentCourse(Integer studentId, Integer courseId);

    @Delete("""
        DELETE FROM student_course
        WHERE student_id = #{studentId}
    """)
    void deleteStudentCourse(Integer studentId);
}
