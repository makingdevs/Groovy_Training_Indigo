package com.makingdevs.repositories;

import org.springframework.data.repository.CrudRepository;

import com.makingdevs.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
  Project findByCodeName(String codeName);
}