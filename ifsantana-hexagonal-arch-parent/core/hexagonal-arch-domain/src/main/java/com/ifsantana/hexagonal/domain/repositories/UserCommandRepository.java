package com.ifsantana.hexagonal.domain.repositories;

import com.ifsantana.hexagonal.domain.models.User;
import org.springframework.stereotype.Component;

@Component
public interface UserCommandRepository {
  Boolean addUser(User user);
}
