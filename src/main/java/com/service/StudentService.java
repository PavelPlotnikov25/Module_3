package com.service;

import com.model.Student;
import com.repository.student.StudentRepository;

import java.util.List;

public class StudentService {
    private static StudentService instance;

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public static StudentService getInstance(){
        if (instance==null){
            instance = new StudentService(StudentRepository.getInstance());
        }
        return instance;
    }

    public List<Student> findStudentsWithGradeBetter(double expectedGrade){
        return repository.findStudentsWithGradeBetter(expectedGrade);
    }
}
