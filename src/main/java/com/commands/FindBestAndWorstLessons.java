package com.commands;

import com.model.Lesson;
import com.service.LessonService;

import java.util.Map;

public class FindBestAndWorstLessons implements Command{

    private static final LessonService LESSON_SERVICE = LessonService.getInstance();

    @Override
    public void execute() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~Find the best and the worst lessons~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Map<Lesson, Double> bestLesson = LESSON_SERVICE.findBestLesson();
        Map<Lesson, Double> worstLesson = LESSON_SERVICE.findWorstLesson();
        System.out.println("The best lesson is " + bestLesson);
        System.out.println("The worst lesson is " + worstLesson);
    }
}
