package com.ifsantana.hexagonalarchapi.controllers.user.v1.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CreateUserResponse extends RepresentationModel<CreateUserResponse> {
  private Long id;
}
