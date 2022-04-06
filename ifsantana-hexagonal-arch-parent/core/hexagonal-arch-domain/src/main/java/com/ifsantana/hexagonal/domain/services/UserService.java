package com.ifsantana.hexagonal.domain.services;

import com.ifsantana.hexagonal.domain.models.User;
import com.ifsantana.hexagonal.domain.repositories.UserCommandRepository;
import internal.v1.commands.createUser.CreateUserCommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.vavr.Tuple2;

@Component
public class UserService {

  private final UserCommandRepository repository;

  @Autowired
  public UserService(UserCommandRepository repository) {
    this.repository = repository;
  }

  public Tuple2<Boolean, CreateUserCommandResponse> addUser(User user) {
    return this.repository.addUser(user);
  }
}
