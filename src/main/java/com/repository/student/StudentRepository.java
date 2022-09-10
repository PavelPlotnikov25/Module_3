package com.repository.student;

import com.config.HibernateSessionFactoryUtil;
import com.model.Student;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentRepository implements IStudentRepository{

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
    private static StudentRepository instance;

    public StudentRepository() {
    }

    public static StudentRepository getInstance(){
        if (instance == null){
            instance = new StudentRepository();
        }
        return instance;
    }


    @Override
    public List<Student> findStudentsWithGradeBetter(double expectedGrade) {
        Session session = sessionFactory.openSession();
        List<Student> result = session.createQuery("from Student s where (select avg(g.grade) from Grade g where g.student.id = s.id) > :expectedGrade", Student.class)
                .setParameter("expectedGrade", expectedGrade)
                .list();
        return result;
    }
}
