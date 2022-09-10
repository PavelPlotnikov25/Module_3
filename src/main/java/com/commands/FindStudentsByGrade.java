package com.commands;

import com.model.Student;
import com.service.StudentService;

import java.util.List;

public class FindStudentsByGrade implements Command{

    private static final StudentService STUDENT_SERVICE = StudentService.getInstance();

    @Override
    public void execute() {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~Find students with average grade greater than we print~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please, enter the average grade (Between 1 and 5");
       Double userInput = scanner.nextDouble();
        List<Student> studentsWithGradeBetter = STUDENT_SERVICE.findStudentsWithGradeBetter(userInput);
        System.out.println(studentsWithGradeBetter);
        if (studentsWithGradeBetter.isEmpty()){
            System.out.println("We dont have so smart/stupid students ;)");
        }


    }
}
