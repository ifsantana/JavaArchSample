package com.ifsantana.hexagonal.application.handlers.commands;

import com.ifsantana.hexagonal.crosscutting.bus.CommandHandler;
import external.v1.events.UserCreatedEvent;
import internal.v1.commands.createUser.CreateUserCommand;
import io.vavr.Tuple2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifsantana.hexagonal.application.usecases.users.CreateUserUseCase;

@Service
public class CreateUserCommandHandler implements
    CommandHandler<CreateUserCommand, Tuple2<Boolean, UserCreatedEvent>> {

  private final CreateUserUseCase createUserUseCase;

  @Autowired
  public CreateUserCommandHandler(CreateUserUseCase createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  @Override
  public Tuple2<Boolean, UserCreatedEvent> handle(CreateUserCommand createUserCommand) {
    return this.createUserUseCase.execute(createUserCommand.getUser());
  }
}
