package com.makingdevs.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingdevs.model.Project;
import com.makingdevs.model.UserStory;
import com.makingdevs.repositories.ProjectRepository;
import com.makingdevs.repositories.UserStoryRepository;
import com.makingdevs.services.UserStoryService;

@Service
public class UserStoryServiceImpl implements UserStoryService {
  
  @Autowired
  ProjectRepository projectRepository;
  
  @Autowired
  UserStoryRepository userStoryRepository;

  @Override
  public void createUserStory(UserStory userStory) {
    userStory.setDateCreated(new Date());
    userStory.setLastUpdated(new Date());
    userStoryRepository.save(userStory);
  }

  @Override
  public List<UserStory> findUserStoriesByProject(String codeName) {
    Project project = projectRepository.findByCodeName(codeName);
    return userStoryRepository.findAllByProject(project);
  }

  @Override
  public boolean isUserStoryDone(Long userStoryId) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public UserStory findUserStoryByIdentifier(Long userStoryId) {
    // TODO Auto-generated method stub
    return null;
  }

}
