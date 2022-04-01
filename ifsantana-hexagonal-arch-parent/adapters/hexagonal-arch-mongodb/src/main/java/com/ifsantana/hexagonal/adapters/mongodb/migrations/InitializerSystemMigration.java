package com.ifsantana.hexagonal.adapters.mongodb.migrations;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import io.mongock.api.annotations.BeforeExecution;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackBeforeExecution;
import io.mongock.api.annotations.RollbackExecution;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(id = "initializer", order = "1", author = "italo.santana", systemVersion = "1")
public class InitializerSystemMigration {
  public static final String USERS_COLLECTION = "users";
  public static final String ID_INDEX = "_id";
  private final MongoTemplate template;

  public InitializerSystemMigration(MongoTemplate template) {
    this.template = template;
  }

  @BeforeExecution
  public void beforeExecution() {
    if(!template.collectionExists(USERS_COLLECTION)) {
      template.createCollection(USERS_COLLECTION);
    }
  }

  @RollbackBeforeExecution
  public void rollbackBeforeExecution() {

  }

  @Execution
  public void initializer() {
    createIndexes(template.getCollection(USERS_COLLECTION));;
  }

  @RollbackExecution
  public void rollback() {

  }

  private MongoCollection<Document> createIndexes(MongoCollection<Document> collection) {
    collection.createIndex(Indexes.ascending(ID_INDEX));
    return collection;
  }
}
