package com.service;

import com.model.Lesson;
import com.repository.lector.LectorRepository;
import com.repository.lesson.LessonRepository;

import java.util.Map;

public class LessonService {

    private static LessonService instance;

    private LessonRepository repository;

    public LessonService(LessonRepository repository) {
        this.repository = repository;
    }

    public static LessonService getInstance(){
        if (instance==null){
            instance = new LessonService(LessonRepository.getInstance());
        }
        return instance;
    }

    public Map<Lesson, Double> findWorstLesson(){
        return repository.findWorstLesson();
    }
    public Map<Lesson, Double> findBestLesson(){
        return repository.findBestLesson();
    }

}
