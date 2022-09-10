package com.commands;

import com.model.Group;
import com.service.GroupService;

import java.util.Map;

public class AverageGrade implements Command{
    private static final GroupService GROUP_SERVICE = GroupService.getInstance();

    @Override
    public void execute() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~Average Grade of every group~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Map<Group, Double> result = GROUP_SERVICE.averageGradeByGroups();
        System.out.println(result);
    }
}
