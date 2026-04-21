package com.example.federation.config;

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

        ds.setDriverClassName("org.h2.Driver");

        ds.setUrl(dotenv.get("DB_URL"));
        ds.setUsername(dotenv.get("DB_USER"));
        ds.setPassword(dotenv.get("DB_PASSWORD"));

        return ds;
    }
}