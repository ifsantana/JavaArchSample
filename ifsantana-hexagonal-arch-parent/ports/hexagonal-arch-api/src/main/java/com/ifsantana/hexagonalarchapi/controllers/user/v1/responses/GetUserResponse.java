package com.ifsantana.hexagonalarchapi.controllers.user.v1.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserResponse {
  private UUID id;
  private String email;
}
