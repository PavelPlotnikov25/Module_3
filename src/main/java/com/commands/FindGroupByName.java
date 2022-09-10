package com.commands;

import com.model.Group;
import com.service.GroupService;

import java.util.List;

public class FindGroupByName implements Command{

    private static final GroupService GROUP_SERVICE = GroupService.getInstance();

    @Override
    public void execute() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~Fining groups by name~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please, enter the name of group");
        String userInput = scanner.nextLine();
        List<Group> groupByName = GROUP_SERVICE.findGroupByName(userInput);
        System.out.println(groupByName);
        if (groupByName.isEmpty()){
            System.out.println("There are 0 groups with name" + userInput);
        }


    }
}
