package com.makingdevs.repositories;

import org.springframework.data.repository.CrudRepository;

import com.makingdevs.model.Sprint;

public interface SprintRepository extends CrudRepository<Sprint, Long> {
  
}