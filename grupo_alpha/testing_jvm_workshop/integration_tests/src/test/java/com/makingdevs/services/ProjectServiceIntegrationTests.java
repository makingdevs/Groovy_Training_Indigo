package com.makingdevs.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.makingdevs.config.PersistenceConfig;
import com.makingdevs.config.ServicesConfig;
import com.makingdevs.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, ServicesConfig.class })
public class ProjectServiceIntegrationTests {

  @Autowired
  ProjectService projectService;

  @Autowired
  ApplicationContext applicationContext;

  @Test
  public void testAppCtx() {
    assertNotNull(applicationContext);
  }

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

}
