package com.makingdevs.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makingdevs.model.Project;
import com.makingdevs.repositories.ProjectRepository;
import com.makingdevs.services.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

  @Autowired
  ProjectRepository projectRepository;

  public void createNewProject(Project project) {
    project.setDateCreated(new Date());
    project.setLastUpdated(new Date());
    project.setCodeName(project.getCodeName().toUpperCase());
    projectRepository.save(project);
  }

  @Transactional(readOnly = true)
  public Project findProjectByCodeName(String codeName) {
    return projectRepository.findByCodeName(codeName);
  }

  @Transactional(readOnly = true)
  public Integer totalEffortForProject(String codeName) {
    // Only for testing purposes
    try {
      Thread.sleep(1005);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

}
