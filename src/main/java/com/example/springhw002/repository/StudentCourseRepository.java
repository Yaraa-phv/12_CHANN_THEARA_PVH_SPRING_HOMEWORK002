package com.example.springhw002.repository;

import com.example.springhw002.model.entity.Courses;
import com.example.springhw002.model.entity.StudentCourses;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseRepository {

//    @Select("""
//        SELECT c.course_id, c.course_name, c.description, c.instructor_id FROM courses c
//        INNER JOIN public.student_course sc ON c.course_id = sc.course_id
//        WHERE student_id = #{studentId}
//    """)
//    @ResultMap("coursesMapper")
//    @Result(property = "studentId", column = "student_id")
//    List<Courses> getCourseByStudentID(Integer studentId);
//
//    @Update("""
//        UPDATE student_course
//        SET course_id = #{courseId}
//        WHERE student_id = #{studentId}
//    """)
//    void updateStudentCourse(Integer studentId, Integer courseId);
//
////    @Select("""
//        SELECT c.course_id, c.course_name, c.description, c.instructor_id FROM courses c
//        INNER JOIN public.student_course sc ON c.course_id = sc.course_id
//        WHERE student_id = #{studentId}
//    """)
//    @Results(id = "StuCourseMapper", value = {
//            @Result(property = "studentId", column = "student_id"),
//            @Result(property = "id",column = "course_id"),
//            @Result(property = "name",column = "course_name"),
//            @Result(property = "instructors", column = "instructor_id",
//                    one = @One(select = "com.example.springhw002.repository.InstructorsRepository.getInstructorByID"))
//    })
//    List<Courses> getCourseByStudentID(Integer studentId);



}
