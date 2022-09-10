package com.config;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static final String SCHEMA = "module";
    private static final String LOCATION = "db/migration";

    public static Flyway getInstance() {
        return Flyway.configure()
                .dataSource(URL, USER, PASSWORD)
                .baselineOnMigrate(true)
                .schemas(SCHEMA)
                .locations(LOCATION)
                .load();
    }
}
