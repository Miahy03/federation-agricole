package com.example.federation.Config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final Dotenv dotenv = Dotenv.load();

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(dotenv.get("DB_URL"));
        ds.setUsername(dotenv.get("DB_USERNAME"));
        ds.setPassword(dotenv.get("DB_PASSWORD"));

        return ds;
    }
}