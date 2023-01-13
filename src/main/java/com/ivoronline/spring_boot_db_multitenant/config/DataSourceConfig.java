package com.ivoronline.spring_boot_db_multitenant.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

  @Bean
  public DataSource dataSource()   {
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
                      dataSourceBuilder.url("jdbc:postgresql://localhost:5432/multitenant");
                      dataSourceBuilder.username("postgres");
                      dataSourceBuilder.password("letmein");
                      dataSourceBuilder.driverClassName("org.postgresql.Driver");
    return            dataSourceBuilder.build();
  }

}