package com.makingdevs.services;

import com.makingdevs.model.Project;

public interface ProjectService {
  void createNewProject(Project project);
  Project findProjectByCodeName(String codeName);
  Integer totalEffortForProject(String codeName);
}