package com.ifsantana.hexagonalarchapi.controllers.user.v1.responses;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetAllUsersResponse {

  private List<GetUserResponse> users;
}
