package com.repository.group;

import com.config.HibernateSessionFactoryUtil;
import com.model.Grade;
import com.model.Group;
import com.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

public class GroupRepository implements IGroupRepository{
    private static GroupRepository instance;
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public GroupRepository() {
    }

    public static GroupRepository getInstance(){
        if (instance == null){
            instance = new GroupRepository();
        }
        return instance;
    }


    @Override
    public List<Group> findGroupByName(String name) {
        Session session = sessionFactory.openSession();
        List<Group> name1 = session.createQuery("from Group group where group.name like :name", Group.class).setParameter("name", "%" + name + "%").getResultList();
        return name1;
    }

    @Override
    public Map<String, Long> countStudentOfGroups() {
        Session session = sessionFactory.openSession();
        Map<String, Long> result = new HashMap<>();
        List resultList = session.createQuery("select n.group.name, count (n.id) from Student n group by n.group.name").getResultList();
        resultList.forEach(o -> {
            Object[] object = (Object[]) o;
            result.put((String) object[0], (Long) object[1]);
        });
        return result;
    }

    @Override
    public Map<Group, Double> averageGradeOfGroups() {
        Session session = sessionFactory.openSession();
        List<Grade> grades = session.createQuery("select g from Grade g").getResultList();
        grades.size();
        Map<Student, List<Grade>> studentListMap = new HashMap<>();
        Map<Group, List<Student>> groupListMap = new HashMap<>();
        grades.forEach(grade -> {
                studentListMap.putIfAbsent(grade.getStudent(), new ArrayList<>());
            List<Grade> list = studentListMap.get(grade.getStudent());
            list.add(grade);
        });
        studentListMap.forEach((student, grades1) -> {
            groupListMap.putIfAbsent(student.getGroup(), new ArrayList<>());
            List<Student> studentList = groupListMap.get(student.getGroup());
            studentList.add(student);
        });
        Map<Group, Double> result = new HashMap<Group, Double>();
        for (Map.Entry<Group, List<Student>> map: groupListMap.entrySet()){
            Group key  = map.getKey();
            int count = 0;
            double sum = 0;
            List<Student> value = map.getValue();
            for (Student student:value){
                List<Grade> grades1 = studentListMap.get(student);
                for (Grade grade:grades1){
                    count++;
                    sum+= grade.getGrade();
                }
            }
            result.put(key,(sum / count));
        }
        return result;
    }

}
