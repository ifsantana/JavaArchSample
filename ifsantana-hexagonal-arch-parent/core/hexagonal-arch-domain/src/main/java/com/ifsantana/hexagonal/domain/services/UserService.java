package com.ifsantana.hexagonal.domain.services;

import com.ifsantana.hexagonal.domain.models.User;
import com.ifsantana.hexagonal.domain.repositories.UserCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  private final UserCommandRepository repository;

  @Autowired
  public UserService(UserCommandRepository repository) {
    this.repository = repository;
  }

  public Boolean addUser(User user) {
    return this.repository.addUser(user);
  }
}
