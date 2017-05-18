package com.makingdevs.repositories

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import com.makingdevs.model.Project
import com.makingdevs.config.*
import spock.lang.*
import groovy.transform.CompileStatic

@ContextConfiguration(classes = [ PersistenceConfig, TestPersistenceConfig ])
class ProjectRepositorySpec extends Specification {

  @Autowired
  ProjectRepository projectRepository
  @Autowired
  JdbcTemplate jdbcTemplate

  def "We have already projects"(){
    when:
    List<Project> projects = projectRepository.findAll()
    projects.each{ p ->
      println p
    }
    then:
    !projects.isEmpty()
  }

  @Unroll
  def "Create a new project"(){
    given: "a new project"
    def p = new Project(
      name:projectName,
      codeName:codeName,
      description:description,
      dateCreated: dateCreated,
      lastUpdated: lastUpdated)
    def totalProjects = jdbcTemplate.queryForObject("select count(*) c from project", Integer)
    when: "we try to save"
    projectRepository.save(p)
    def newTotalProjects = jdbcTemplate.queryForObject("select count(*) c from project", Integer)
    then: "we have one more project"
    totalProjects + 1 == newTotalProjects
    where:
    projectName | codeName | description | dateCreated    | lastUpdated
    "Proj 1"    | "P1"     | "* "*20     | new Date()     | new Date()
    "Proj 2"    | "P2"     | "- "*20     | new Date()-10  | new Date() - 5
    "Proj 3"    | "P3"     | "/ "*20     | new Date()-30  | new Date() - 20
  }

}
