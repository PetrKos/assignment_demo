package com.assessment.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * todo add javadoc
 */
@Configuration
public class DatabaseConfig {
  @Bean
  public DataSource getDataSource() {
    return DataSourceBuilder.create()
            .driverClassName("org.postgresql.Driver")
            .url("jdbc:postgresql://localhost:5432/bet_demo")
            .username("postgres")
            .password("asd123")
            .build();
  }
}
