package com.ifsantana.hexagonal.adapters.mongodb.repositories;

import com.ifsantana.hexagonal.adapters.mongodb.models.UserDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<UserDataModel, Long> {
}
