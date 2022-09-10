package com.commands;

import com.model.Lector;
import com.service.LectorService;

import java.util.List;

public class FindLector implements Command{
    private static final LectorService LECTOR_SERVICE = LectorService.getInstance();


    @Override
    public void execute() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~Find lector by name~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please, enter the lector's first name or last name");
        String userInput = scanner.nextLine();
        List<Lector> lectorByName = LECTOR_SERVICE.findLectorByName(userInput);
        System.out.println(lectorByName);
        if (lectorByName.isEmpty()){
            System.out.println("We don't have this lector");
        }
    }
}
