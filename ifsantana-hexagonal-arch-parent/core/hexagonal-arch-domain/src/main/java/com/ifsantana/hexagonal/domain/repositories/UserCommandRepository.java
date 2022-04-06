package com.ifsantana.hexagonal.domain.repositories;

import com.ifsantana.hexagonal.domain.models.User;
import internal.v1.commands.createUser.CreateUserCommandResponse;
import org.springframework.stereotype.Component;
import io.vavr.Tuple2;

@Component
public interface UserCommandRepository {
  Tuple2<Boolean, CreateUserCommandResponse> addUser(User user);
}
