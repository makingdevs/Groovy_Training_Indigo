package com.makingdevs.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate

import javax.sql.DataSource

@Configuration
class TestPersistenceConfig {

  @Autowired
  DataSource dataSource

  @Bean
  JdbcTemplate jdbcTemplate(){
    new JdbcTemplate(dataSource)
  }
}

