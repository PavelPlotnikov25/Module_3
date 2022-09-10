package com.repository.lesson;

import com.config.HibernateSessionFactoryUtil;
import com.model.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonRepository implements ILessonRepository{

    private static LessonRepository instance;

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public LessonRepository() {
    }

    public static LessonRepository getInstance(){
        if (instance==null){
            instance = new LessonRepository();
        }
        return instance;
    }

    @Override
    public Map<Lesson, Double> findBestLesson() {
        Session session = sessionFactory.openSession();
        List resultList = session.createQuery("select avg(s.grade),s.lesson.id, l from Grade s, Lesson l where s.lesson.id = l.id group by s.lesson.id, l.id order by avg(s.grade) desc").getResultList();
        Object [] best = (Object[]) resultList.get(0);
        Map<Lesson, Double> bestLesson = new HashMap<>();
        bestLesson.put((Lesson) best[2], (Double) best[0]);
        return bestLesson;
    }

    @Override
    public Map<Lesson, Double> findWorstLesson() {
        Session session = sessionFactory.openSession();
        List resultList = session.createQuery("select avg(s.grade),s.lesson.id, l from Grade s, Lesson l where s.lesson.id = l.id group by s.lesson.id, l.id order by avg(s.grade)").getResultList();
        Object [] worst = (Object[]) resultList.get(0);
        Map<Lesson, Double> worstLesson = new HashMap<>();
        worstLesson.put((Lesson) worst[2], (Double) worst[0]);
        return worstLesson;
    }
}
