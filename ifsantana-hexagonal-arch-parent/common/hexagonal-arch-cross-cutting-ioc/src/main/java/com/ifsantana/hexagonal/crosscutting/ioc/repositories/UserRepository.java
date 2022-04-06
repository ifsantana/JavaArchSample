package com.ifsantana.hexagonal.crosscutting.ioc.repositories;

import com.ifsantana.hexagonal.domain.models.User;
import com.ifsantana.hexagonal.domain.repositories.UserCommandRepository;
import internal.v1.commands.createUser.CreateUserCommandResponse;
import io.vavr.Tuple2;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends UserCommandRepository {

  @Override
  Tuple2<Boolean, CreateUserCommandResponse> addUser(User user);
}
