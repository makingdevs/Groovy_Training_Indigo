package com.makingdevs.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.makingdevs.model.Task;
import com.makingdevs.model.TaskStatus;
import com.makingdevs.model.UserStory;

public interface TaskRepository extends CrudRepository<Task, Long> {
  List<Task> findAllByDescriptionLike(String description);
  List<Task> findAllByUserStoryAndStatusEquals(UserStory userStory,TaskStatus taskStatus);
  // List<Task> findAllByUser(User user);
}