package com.ifsantana.hexagonal.crosscutting.ioc.repositories;

import com.ifsantana.hexagonal.domain.models.User;
import com.ifsantana.hexagonal.domain.repositories.UserCommandRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends UserCommandRepository {

  @Override
  Boolean addUser(User user);
}
