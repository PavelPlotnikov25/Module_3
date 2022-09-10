package com.repository.lector;

import com.config.HibernateSessionFactoryUtil;
import com.model.Lector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LectorRepository implements ILectorRepository{

    private static LectorRepository instance;
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public LectorRepository() {
    }

    public static LectorRepository getInstance(){
        if (instance==null){
            instance = new LectorRepository();
        }
        return instance;
    }

    @Override
    public List findLectorByName(String name) {
        Session session = sessionFactory.openSession();
        return session.createQuery("select lector from Lector lector where lector.firstName like :firstName or lector.lastName like :lastName", Lector.class)
                .setParameter("firstName", "%" + name + "%")
                .setParameter("lastName", "%" + name + "%")
                .getResultList();
    }
}
