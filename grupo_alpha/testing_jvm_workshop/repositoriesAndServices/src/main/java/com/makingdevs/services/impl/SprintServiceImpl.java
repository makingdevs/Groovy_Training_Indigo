package com.makingdevs.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makingdevs.model.Sprint;
import com.makingdevs.repositories.SprintRepository;
import com.makingdevs.services.SprintService;

@Service
public class SprintServiceImpl implements SprintService {
  
  @Autowired
  SprintRepository sprintRepository;

  @Override
  public void createSprintForOneproject(Sprint sprint) {
    sprint.setDateCreated(new Date());
    sprint.setLastUpdated(new Date());
    sprintRepository.save(sprint);
  }

}
