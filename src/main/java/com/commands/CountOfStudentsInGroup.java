package com.commands;

import com.service.GroupService;

import java.util.Map;

public class CountOfStudentsInGroup implements Command{
    private static final GroupService GROUP_SERVICE = GroupService.getInstance();
    @Override
    public void execute() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~Count of students in Groups~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Map<String, Long> result = GROUP_SERVICE.countStudentOfGroups();
        System.out.println(result);

    }
}
