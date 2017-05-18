package com.makingdevs.services

import com.makingdevs.config.PersistenceConfig
import com.makingdevs.config.ServicesConfig
import com.makingdevs.model.Project
import com.makingdevs.model.UserStory
import com.makingdevs.repositories.ProjectRepository
import com.makingdevs.repositories.UserStoryRepository
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by neodevelop on 18/05/17.
 */
@ContextConfiguration(classes = [PersistenceConfig, ServicesConfig])
class UserServiceSpec extends Specification {

  @Autowired
  UserStoryService userStoryService

  @Autowired
  ProjectRepository projectRepository

  @Autowired
  UserStoryRepository userStoryRepository

  @Shared sql = Sql.newInstance(
      'jdbc:mysql://localhost/db_test',
      'makingdevs',
      'makingdevs',
      'com.mysql.jdbc.Driver')

  @Unroll
  def "Add a new user story to an existent project"(){
    given:"An existent project"
      Project p = projectRepository.findOne(id)
      def userStoriesInitial = userStoryRepository.findAllByProject(p)

    and: "a new user story"
      UserStory us = new UserStory(
          description: description,
          priority: priority,
          effort: effort)

    when:"we try to add the US to this project"
      userStoryService.createUserStory(us, p)
      def userStoriesFinal = userStoryRepository.findAllByProject(p)

    then:"the project should have one more user story"
      userStoriesFinal.size() == userStoriesInitial.size() + 1
      userStoriesFinal.any { u -> u.description == description }
      us.project == p
      userStoriesFinal.every { u -> u.project.id == p.id }
    where:
    [id,description, priority,effort] << sql.rows("select * from data_test")
    //id << [1L,2L,3L]
    //description << ["Desc1","Desc2","Desc3"]
    //priority << [5,4,1]
    //effort << [7,3,1]
  }

  def "Add a new user story to a new project"(){}

  def "Add a new user story to a non existent project(should fail)"(){}
}

