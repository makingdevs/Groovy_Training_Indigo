package com.makingdevs.services;

import java.util.List;

import com.makingdevs.model.Task;
import com.makingdevs.model.TaskStatus;

public interface TaskService {
  Task createTaskForUserStory(String taskDescription, Long userStoryId);
  List<Task> createTasksForUserStory(List<String> tasksDescriptionsList, Long userStoryId);
  void assignTaskToUser(Long taskId, String username);
  void changeTaskStatus(Long taskId, TaskStatus taskStatus);
}