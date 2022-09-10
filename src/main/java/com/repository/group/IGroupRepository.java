package com.repository.group;

import com.model.Group;

import java.util.List;
import java.util.Map;

public interface IGroupRepository {

    List<Group> findGroupByName(String name);

    Map<String, Long> countStudentOfGroups();

    Map<Group, Double> averageGradeOfGroups();

}
