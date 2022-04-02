package com.ifsantana.hexagonal.application.usecases.users;

import com.ifsantana.hexagonal.domain.models.User;
import com.ifsantana.hexagonal.domain.services.UserService;
import external.v1.events.UserCreatedEvent;
import internal.v1.commands.models.NewUser;
import io.vavr.Tuple2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

  private final UserService userService;

  @Autowired
  public CreateUserUseCase(UserService userService) {
    this.userService = userService;
  }

  public Tuple2<Boolean, UserCreatedEvent> execute(NewUser user) {
      var newUser = new User(null, user.getEmail());
      var success = this.userService.addUser(newUser);
      return new Tuple2<>(success, new UserCreatedEvent(newUser.getId(), newUser.getEmail()));
  }
}
