package com.makingdevs.services;

import com.makingdevs.model.User;

public interface UserService {
  User findUserByUsername(String username);
  User createUser(String username);
  void addToProject(String username, String codeName);
}