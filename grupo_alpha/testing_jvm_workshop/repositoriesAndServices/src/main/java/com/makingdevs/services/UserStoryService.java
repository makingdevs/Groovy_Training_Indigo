package com.makingdevs.services;

import java.util.List;

import com.makingdevs.model.Project;
import com.makingdevs.model.UserStory;

public interface UserStoryService {
  void createUserStory(UserStory userStory, Project project);
  List<UserStory> findUserStoriesByProject(String codeName);
  boolean isUserStoryDone(Long userStoryId);
  UserStory findUserStoryByIdentifier(Long userStoryId);
}