package com.makingdevs.services

import com.makingdevs.config.PersistenceConfig
import com.makingdevs.config.ServicesConfig
import com.makingdevs.model.Project
import com.makingdevs.model.UserStory
import com.makingdevs.repositories.ProjectRepository
import com.makingdevs.repositories.UserStoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

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

  def "Add a new user story to an existent project"(){
    given:"An existent project"
      Project p = projectRepository.findOne(1L)
      def userStoriesInitial = userStoryRepository.findAllByProject(p)

    and: "a new user story"
      UserStory us = new UserStory(description: "uniq desc", priority: 3, effort: 4)

    when:"we try to add the US to this project"
      userStoryService.createUserStory(us, p)
      def userStoriesFinal = userStoryRepository.findAllByProject(p)

    then:"the project should have one more user story"
      userStoriesFinal.size() == userStoriesInitial.size() + 1
      userStoriesFinal.any { u -> u.description == "uniq desc" }
      us.project == p
      userStoriesFinal.every { u -> u.project.id == p.id }
  }

  def "Add a new user story to a new project"(){}

  def "Add a new user story to a non existent project(should fail)"(){}
}

