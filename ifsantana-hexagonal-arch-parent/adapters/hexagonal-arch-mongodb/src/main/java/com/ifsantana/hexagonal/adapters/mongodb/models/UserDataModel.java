package com.ifsantana.hexagonal.adapters.mongodb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "users")
public class UserDataModel {
  private Long id;
  private String email;
}
