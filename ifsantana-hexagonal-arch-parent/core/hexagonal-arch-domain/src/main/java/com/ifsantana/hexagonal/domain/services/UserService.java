package com.ifsantana.hexagonal.domain.services;

import com.ifsantana.hexagonal.domain.models.User;
import com.ifsantana.hexagonal.domain.repositories.UserCommandRepository;
import internal.v1.commands.createUser.CreateUserCommandResponse;
import io.vavr.Tuple2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserCommandRepository repository;

  public Tuple2<Boolean, CreateUserCommandResponse> addUser(User user) {
    return this.repository.addUser(user);
  }
}
