package com.ifsantana.hexagonal.application.usecases.users;

import com.ifsantana.hexagonal.crosscutting.bus.InMemoryBus;
import com.ifsantana.hexagonal.domain.models.User;
import com.ifsantana.hexagonal.domain.services.UserService;
import external.v1.events.UserCreatedEvent;
import internal.v1.commands.createUser.CreateUserCommandResponse;
import internal.v1.commands.models.NewUser;
import io.vavr.Tuple2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

  @Autowired
  private InMemoryBus inMemoryBus;
  @Autowired
  private UserService userService;

  public Tuple2<Boolean, CreateUserCommandResponse> execute(NewUser user) {
      var result = this.userService.addUser(new User(user.getId(), user.getEmail()));

      if(result._1()) {
        this.inMemoryBus.publishEvent(new UserCreatedEvent(result._2().getUser()));
      }
      return new Tuple2<>(result._1(), result._2());
  }
}
