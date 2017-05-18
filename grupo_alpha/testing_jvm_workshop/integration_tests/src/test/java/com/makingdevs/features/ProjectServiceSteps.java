package com.makingdevs.features;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.makingdevs.config.PersistenceConfig;
import com.makingdevs.config.ServicesConfig;
import com.makingdevs.model.Project;
import com.makingdevs.services.ProjectService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = { PersistenceConfig.class, ServicesConfig.class })
public class ProjectServiceSteps {

  @Autowired
  ProjectService projectService;

  private Project project;
  private List<Project> projects;

  @Given("^a project named \"(.*?)\"$")
  public void a_project_named(String projectName) throws Throwable {
    project = new Project();
    project.setName(projectName);
  }

  @Given("^the codename is \"(.*?)\", with the description \"(.*?)\"$")
  public void the_codename_is_with_the_description(String codeName,
      String description) throws Throwable {
    project.setCodeName(codeName);
    project.setDescription(description);
  }

  @When("^I use the projectService$")
  public void i_use_the_projectService() throws Throwable {
    projectService.createNewProject(project);
  }

  @Then("^the project must have an id and date created$")
  public void the_project_must_have_an_id_and_date_created() throws Throwable {
    Assert.assertNotNull(project.getId());
    Assert.assertNotNull(project.getDateCreated());
    System.out.println(project.getId());
  }

  /*************************************/

  @Given("^some projects$")
  public void some_projects(List<Project> dataProjects) throws Throwable {
    projects = dataProjects;
  }
  
  @When("^I use the projectService on the project's list$")
  public void i_use_the_projectService_on_the_project_s_list() throws Throwable {
    for(Project p:projects){
      projectService.createNewProject(p);
    }
  }
  
  @Then("^each project must have an id and date created$")
  public void each_project_must_have_an_id_and_date_created() throws Throwable {
      for(Project p:projects){
        Assert.assertNotNull(p.getId());
        Assert.assertNotNull(p.getDateCreated());
      }
  }

}
