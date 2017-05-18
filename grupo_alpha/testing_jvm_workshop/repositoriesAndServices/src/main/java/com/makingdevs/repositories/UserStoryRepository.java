package com.makingdevs.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.makingdevs.model.Project;
import com.makingdevs.model.UserStory;

public interface UserStoryRepository extends CrudRepository<UserStory, Long> {
  List<UserStory> findAllByEffortBetween(Integer lowValue, Integer maxValue);
  List<UserStory> findAllByPriorityBetween(Integer lowValue, Integer maxValue);
  List<UserStory> findAllByProject(Project project);
}