package com.ifsantana.hexagonal.crosscutting.ioc.configuration;

import com.ifsantana.hexagonal.adapters.mongodb.factories.UserDataModelFactory;
import com.ifsantana.hexagonal.adapters.mongodb.repositories.UserMongoDbAdapter;
import com.ifsantana.hexagonal.adapters.mongodb.services.SequenceGeneratorService;
import com.ifsantana.hexagonal.application.handlers.commands.CreateUserCommandHandler;
import com.ifsantana.hexagonal.application.usecases.users.CreateUserUseCase;
import com.ifsantana.hexagonal.crosscutting.bus.CommandHandler;
import com.ifsantana.hexagonal.domain.repositories.UserCommandRepository;
import com.ifsantana.hexagonal.domain.services.UserService;
import internal.v1.commands.createUser.CreateUserCommand;
import internal.v1.commands.createUser.CreateUserCommandResponse;
import io.vavr.Tuple2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersConfig {

  @Bean
  public SequenceGeneratorService sequenceGeneratorService() {
    return new SequenceGeneratorService();
  }

  @Bean
  public UserDataModelFactory userDataModelFactory() {
    return new UserDataModelFactory();
  }

  @Bean
  public UserCommandRepository userCommandRepository() {
    return new UserMongoDbAdapter();
  }

  @Bean
  public UserService userService() {
    return new UserService();
  }

  @Bean
  public CreateUserUseCase createUserUseCase() {
    return new CreateUserUseCase();
  }

  @Bean
  public CommandHandler<CreateUserCommand, Tuple2<Boolean, CreateUserCommandResponse>> createUserCommandHandler() {
    return new CreateUserCommandHandler();
  }
}
