package com.ifsantana.hexagonal.adapters.mongodb.factories;


import com.ifsantana.hexagonal.adapters.mongodb.models.UserDataModel;
import com.ifsantana.hexagonal.crosscutting.factories.AbstractFactory;
import com.ifsantana.hexagonal.domain.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserDataModelFactory implements AbstractFactory<UserDataModel, User> {

  @Override
  public UserDataModel create(User param) {
    return new UserDataModel(param.getId(), param.getEmail());
  }
}
