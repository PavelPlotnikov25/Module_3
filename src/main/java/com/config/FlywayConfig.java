package com.config;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
    private static final String URL = "jdbc:postgresql://ec2-52-200-5-135.compute-1.amazonaws.com:5432/deimk83oeleopg";
    private static final String USER = "qaaclpdmmcwymt";
    private static final String PASSWORD = "cb92dfb540428f30e2a97ae59cc98800fdd8204c07359467d66d4b0b9e877c3e";
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
