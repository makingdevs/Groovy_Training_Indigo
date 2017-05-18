package com.makingdevs.repositories;

import org.springframework.data.repository.CrudRepository;

import com.makingdevs.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
  // So many methods as you want...
}