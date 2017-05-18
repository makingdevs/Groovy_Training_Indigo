package com.makingdevs.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.makingdevs.config.PersistenceConfig;
import com.makingdevs.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class })
public class ProjectRepositoryIntegrationTests {

  @Autowired
  ProjectRepository projectRepository;

  JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Test
  public void testTheCreationOfNewInstance() {
    final int count = countRowsInTable("project");
    Project p = new Project();
    p.setCodeName("CODE");
    p.setDateCreated(new Date());
    p.setLastUpdated(new Date());
    p.setDescription("Descripcion");
    p.setName("Proyecto");
    projectRepository.save(p);
    Assert.assertTrue(p.getId() > 0L);
    assertTotalInstancesInTable(count + 1);
  }
  
  protected int countRowsInTable(String tableName) {
    return JdbcTestUtils.countRowsInTable(this.jdbcTemplate, tableName);
  }

  protected void assertTotalInstancesInTable(int expected) {
    assertEquals("Number of rows in the 'project' table.", expected,
        countRowsInTable("project"));
  }
}
