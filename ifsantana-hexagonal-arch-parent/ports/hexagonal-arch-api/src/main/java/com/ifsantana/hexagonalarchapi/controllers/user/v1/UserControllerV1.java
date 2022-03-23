package com.ifsantana.hexagonalarchapi.controllers.user.v1;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserControllerV1 {

  @Operation(operationId = "get-users", tags = {"users"})
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpStatus getUsers() {
    return HttpStatus.OK;
  }
}