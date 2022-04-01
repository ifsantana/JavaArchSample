package com.ifsantana.hexagonal.adapters.mongodb.repositories;

import com.ifsantana.hexagonal.adapters.mongodb.factories.UserDataModelFactory;
import com.ifsantana.hexagonal.crosscutting.ioc.repositories.UserRepository;
import com.ifsantana.hexagonal.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public Boolean addUser(User user) {
    return this.repository.save(userDataModelFactory.create(user)) != null;
  }
}
