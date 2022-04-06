package com.ifsantana.hexagonal.adapters.mongodb.repositories;

import com.ifsantana.hexagonal.adapters.mongodb.factories.UserDataModelFactory;
import com.ifsantana.hexagonal.crosscutting.ioc.repositories.UserRepository;
import com.ifsantana.hexagonal.domain.models.User;
import internal.v1.commands.createUser.CreateUserCommandResponse;
import internal.v1.commands.models.NewUser;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.vavr.Tuple2;

@Service
public class UserRepositoryImpl implements UserRepository {

  private final UserDataModelFactory userDataModelFactory;
  private final UserMongoRepository repository;

  @Autowired
  public UserRepositoryImpl(
      UserDataModelFactory userDataModelFactory,
      UserMongoRepository repository) {
    this.userDataModelFactory = userDataModelFactory;
    this.repository = repository;
  }

  @Override
  public Tuple2<Boolean, CreateUserCommandResponse> addUser(User user) {
    var result = this.repository.save(userDataModelFactory.create(user));

    if(Objects.nonNull(result)) {
      return new Tuple2<>(true, new CreateUserCommandResponse(new NewUser(result.getId(), result.getEmail())));
    }
    return new Tuple2<>(false, null);
  }
}
