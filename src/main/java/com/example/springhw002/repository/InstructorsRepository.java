package com.example.springhw002.repository;

import com.example.springhw002.model.dto.request.InstructorRequest;
import com.example.springhw002.model.entity.Instructors;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorsRepository {

    @Select("""
        SELECT * FROM instructors
    """)
    @Results(id = "instructorMapper", value = {
            @Result(property = "id", column = "instructor_id"),
            @Result(property = "name", column = "instructor_name"),
    })
    List<Instructors> getAllInstructors();

    @Select("""
        INSERT INTO instructors(instructor_name, email)
        VALUES (#{add.name}, #{add.email})
        RETURNING *
    """)
    @ResultMap("instructorMapper")
    Instructors addInstructor(@Param("add")InstructorRequest instructorRequest);

    @Select("""
        SELECT * FROM instructors
        WHERE instructor_id = #{id}
    """)
    @ResultMap("instructorMapper")
    Instructors getInstructorByID(Integer id);

    @Select("""
        UPDATE instructors 
        SET instructor_name = #{request.name}, email = #{request.email} 
        WHERE instructor_id = #{id}
        RETURNING *
    """)
    @ResultMap("instructorMapper")
    Instructors updateInstructorByID(Integer id, @Param("request") InstructorRequest instructorRequest);

    @Select("""
        DELETE FROM instructors 
        WHERE instructor_id = #{id}
        RETURNING *
    """)
    @ResultMap("instructorMapper")
    Instructors deletedInstructorByID(Integer id);
}
