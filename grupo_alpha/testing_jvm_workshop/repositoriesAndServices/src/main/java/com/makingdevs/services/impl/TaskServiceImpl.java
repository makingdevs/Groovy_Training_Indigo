package com.makingdevs.services.impl;

import java.util.List;

import com.makingdevs.model.Task;
import com.makingdevs.model.TaskStatus;
import com.makingdevs.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

  @Override
  public Task createTaskForUserStory(String taskDescription, Long userStoryId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Task> createTasksForUserStory(List<String> tasksDescriptionsList,
      Long userStoryId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void assignTaskToUser(Long taskId, String username) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void changeTaskStatus(Long taskId, TaskStatus taskStatus) {
    // TODO Auto-generated method stub
    
  }

}
