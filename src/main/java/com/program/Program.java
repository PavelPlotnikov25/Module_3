package com.program;

import com.commands.*;
import com.config.FlywayConfig;
import com.config.HibernateSessionFactoryUtil;
import com.service.GroupService;
import com.service.LectorService;
import com.service.LessonService;
import com.service.StudentService;
import org.flywaydb.core.Flyway;

import java.util.List;

public class Program {

    public void run(){
        HibernateSessionFactoryUtil.getSessionFactory();
        Flyway flyway = FlywayConfig.getInstance();
        flyway.clean();
        flyway.migrate();

        boolean exit = false;
        final Commands[] values = Commands.values();
        final List<String> names = UserInputUtil.getNamesOfType(values);
        do {
            int commandIndex = UserInputUtil.getUserInput(values.length, names);
            switch (values[commandIndex]) {
                case FIND_GROUP_BY_NAME -> new FindGroupByName().execute();
                case COUNT_OF_STUDENTS_IN_GROUPS -> new CountOfStudentsInGroup().execute();
                case AVERAGE_GRADE -> new AverageGrade().execute();
                case FIND_LECTOR -> new FindLector().execute();
                case BEST_AND_WORST_LESSONS -> new FindBestAndWorstLessons().execute();
                case FIND_STUDENTS_BY_GRADE -> new FindStudentsByGrade().execute();
            }

        } while (!exit);
    }
}
