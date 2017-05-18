package com.makingdevs.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.makingdevs.config.PersistenceConfig;
import com.makingdevs.config.ServicesConfig;
import com.makingdevs.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, ServicesConfig.class })
// @Transactional
public class ProjectServiceTxIntegrationTests {

  @Autowired
  ProjectService projectService;

  // @Rollback(true) // Only works if the test is @Transactional
  // @Repeat(5)
  @Test
  public void testCreateNewProject() {
    Project p = new Project();
    p.setCodeName("MakingDevs");
    p.setDescription("Some description");
    p.setName("Nuevo proyecto en MakingDevs");
    projectService.createNewProject(p);
    assertNotNull(p.getId());
    assertNotNull(p.getDateCreated());
    assertNotNull(p.getLastUpdated());
    assertEquals(p.getCodeName(), "MAKINGDEVS");
  }

  @Test
  @Timed(millis = 1000)
  // @Sql({""}) // Only available en earlier versions of Spring 4
  public void testLongTransaction() {
    projectService.totalEffortForProject("SOMECODE");
  }

  @BeforeTransaction
  public void beforeTransaction() {
    System.out.println("Prepare the transaction");
  }

  @AfterTransaction
  public void afterTransaction() {
    System.out.println("Ending the transaction");
  }

}
