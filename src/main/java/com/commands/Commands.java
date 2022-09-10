package com.commands;

import lombok.Getter;

@Getter
public enum Commands {

    FIND_GROUP_BY_NAME("Find group by name" , new FindGroupByName()),
    COUNT_OF_STUDENTS_IN_GROUPS("Count of students in groups", new CountOfStudentsInGroup()),
    AVERAGE_GRADE("Average grade of every gropu", new AverageGrade()),
    FIND_LECTOR("Find ltctor by first name or last name", new FindLector()),
    BEST_AND_WORST_LESSONS("The best and the worst lessons", new FindBestAndWorstLessons()),
    FIND_STUDENTS_BY_GRADE("Find students, who has average grade greater than we print",new FindStudentsByGrade());


    private final String name;
    private final Command command;

    Commands(String name, Command command) {
        this.name = name;
        this.command = command;
    }
}
