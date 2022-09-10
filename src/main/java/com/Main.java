package com;

import com.config.FlywayConfig;
import com.config.HibernateSessionFactoryUtil;
import com.program.Program;
import com.repository.group.GroupRepository;
import com.service.GroupService;
import org.flywaydb.core.Flyway;

public class Main {



    public static void main(String[] args) {
        Program program = new Program();
        program.run();

    }
}
