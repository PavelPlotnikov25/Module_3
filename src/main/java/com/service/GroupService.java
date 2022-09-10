package com.service;

import com.model.Group;
import com.repository.group.GroupRepository;

import java.util.List;
import java.util.Map;

public class GroupService {

    private static GroupService instance;
    private GroupRepository repository;

    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    public static GroupService getInstance(){
        if (instance== null){
            instance = new GroupService(GroupRepository.getInstance());
        }
        return instance;
    }

    public List<Group> findGroupByName(String name){
        return repository.findGroupByName(name);
    }

    public Map<String, Long> countStudentOfGroups(){
        return repository.countStudentOfGroups();
    }

    public Map<Group, Double> averageGradeByGroups(){
        return repository.averageGradeOfGroups();
    }
}
