package com.ifsantana.hexagonal.application.usecases.users;

import external.v1.events.UserCreatedEvent;
import internal.v1.commands.models.NewUser;
import io.vavr.Tuple2;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

  public Tuple2<Boolean, UserCreatedEvent> execute(NewUser user) {
      return new Tuple2<>(Boolean.TRUE, new UserCreatedEvent("admin@admin.com"));
  }
}
