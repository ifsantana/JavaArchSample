package com.ifsantana.hexagonal.application.handlers.commands;

import com.ifsantana.hexagonal.application.usecases.users.DeleteUserUseCase;
import com.ifsantana.hexagonal.crosscutting.bus.CommandHandler;
import external.v1.events.UserDeletedEvent;
import internal.v1.commands.DeleteUserCommand;
import io.vavr.Tuple2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserCommandHandler implements
    CommandHandler<DeleteUserCommand, Tuple2<Boolean, UserDeletedEvent>> {

  private final DeleteUserUseCase deleteUserUseCase;

  @Autowired
  public DeleteUserCommandHandler(DeleteUserUseCase deleteUserUseCase) {
    this.deleteUserUseCase = deleteUserUseCase;
  }

  @Override
  public Tuple2<Boolean, UserDeletedEvent> handle(DeleteUserCommand deleteUserCommand) {
    return this.deleteUserUseCase.execute(deleteUserCommand.getUser());
  }
}