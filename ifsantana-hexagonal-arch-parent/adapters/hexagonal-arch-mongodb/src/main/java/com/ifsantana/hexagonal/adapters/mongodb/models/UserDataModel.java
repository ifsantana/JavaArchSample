package com.ifsantana.hexagonal.adapters.mongodb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "users")
public class UserDataModel {
  @Transient
  public static final String SEQUENCE_NAME = "users_sequence";

  @Id
  private Long id;
  private String email;
}
