package com.repository.lesson;

import com.model.Lesson;

import java.util.Map;

public interface ILessonRepository {

    Map <Lesson, Double> findBestLesson();

    Map<Lesson, Double> findWorstLesson();
}
