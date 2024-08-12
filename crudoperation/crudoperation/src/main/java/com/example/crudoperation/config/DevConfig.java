package com.example.crudoperation.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class DevConfig {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev_db");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    // Other beans specific to the development profile
}
