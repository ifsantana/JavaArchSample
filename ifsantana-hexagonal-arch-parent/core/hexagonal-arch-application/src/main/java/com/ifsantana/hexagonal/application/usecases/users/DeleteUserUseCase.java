package com.ifsantana.hexagonal.application.usecases.users;

import external.v1.events.UserDeletedEvent;
import internal.v1.commands.models.NewUser;
import io.vavr.Tuple2;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCase {

  public Tuple2<Boolean, UserDeletedEvent> execute(NewUser user) {
    return new Tuple2<>(Boolean.TRUE, new UserDeletedEvent("admin@admin.com"));
  }
}
