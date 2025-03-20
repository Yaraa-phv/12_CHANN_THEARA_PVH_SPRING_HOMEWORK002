package com.example.springhw002.service.Impl;

import com.example.springhw002.model.dto.request.InstructorRequest;
import com.example.springhw002.model.entity.Instructors;
import com.example.springhw002.repository.InstructorsRepository;
import com.example.springhw002.service.InstructorsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorsServiceImpl implements InstructorsService {

    private final InstructorsRepository instructorsRepository;

    public InstructorsServiceImpl(InstructorsRepository instructorsRepository){
        this.instructorsRepository = instructorsRepository;
    }

    @Override
    public List<Instructors> getAllInstructors(Integer offset, Integer limit){
        return instructorsRepository.getAllInstructors(offset, limit);
    }

    @Override
    public Instructors addInstructor(InstructorRequest instructorRequest) {
        return instructorsRepository.addInstructor(instructorRequest)    ;
    }

    @Override
    public Instructors getInstructorByID(Integer id) {
        return instructorsRepository.getInstructorByID(id);
    }

    @Override
    public Instructors updateInstructorByID(Integer id, InstructorRequest instructorRequest) {
        return instructorsRepository.updateInstructorByID(id, instructorRequest);
    }

    @Override
    public Instructors deleteInstructorByID(Integer id) {
        return instructorsRepository.deletedInstructorByID(id);
    }
}
