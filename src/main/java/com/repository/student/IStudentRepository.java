package com.repository.student;

import com.model.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> findStudentsWithGradeBetter(double grade);

}
