package com.ifsantana.hexagonal.adapters.mongodb.repositories;

import com.ifsantana.hexagonal.adapters.mongodb.factories.UserDataModelFactory;
import com.ifsantana.hexagonal.domain.models.User;
import com.ifsantana.hexagonal.domain.repositories.UserCommandRepository;
import internal.v1.commands.createUser.CreateUserCommandResponse;
import internal.v1.commands.models.NewUser;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.vavr.Tuple2;

@Service
public class UserMongoDbAdapter implements UserCommandRepository {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserDataModelFactory userDataModelFactory;

  @Override
  public Tuple2<Boolean, CreateUserCommandResponse> addUser(User user) {
    var result = this.userRepository.save(userDataModelFactory.create(user));

    if(Objects.nonNull(result)) {
      return new Tuple2<>(true, new CreateUserCommandResponse(new NewUser(result.getId(), result.getEmail())));
    }
    return new Tuple2<>(false, null);
  }
}
