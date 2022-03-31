package com.ifsantana.hexagonalarchapi.controllers.user.v1;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.ifsantana.hexagonal.crosscutting.bus.InMemoryBus;
import com.ifsantana.hexagonalarchapi.controllers.user.v1.requests.CreateUserRequest;
import com.ifsantana.hexagonalarchapi.controllers.user.v1.requests.UpdateUserRequest;
import com.ifsantana.hexagonalarchapi.controllers.user.v1.responses.CreateUserResponse;
import internal.v1.commands.CreateUserCommand;
import internal.v1.commands.models.NewUser;
import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserControllerV1 {

  private final InMemoryBus inMemoryBus;
  public CreateUserResponse response = new CreateUserResponse(9877654L);

  @Autowired
  public UserControllerV1(InMemoryBus inMemoryBus) {
    this.inMemoryBus = inMemoryBus;
  }


  @Operation(operationId = "get-users", tags = {"users"})
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpStatus getUsers() {
    return HttpStatus.OK;
  }

  @Operation(operationId = "get-users", tags = {"users"})
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getUser(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.response);
  }

  @Operation(operationId = "create-user", tags = {"users"})
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createUser(@RequestBody CreateUserRequest request) throws URISyntaxException {

    this.inMemoryBus.publishEvent(new CreateUserCommand(new NewUser("admin@admin.com")));

    return ResponseEntity.status(HttpStatus.CREATED)
        .location(new URI(linkTo(UserControllerV1.class)
            .slash(this.response.getId()).withSelfRel()
            .getHref()))
        .body(this.response);
  }

  @Operation(operationId = "update-user", tags = {"users"})
  @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpStatus updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
    return HttpStatus.OK;
  }

  @Operation(operationId = "delete-user", tags = {"users"})
  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpStatus deleteUser(@PathVariable Long id) {
    return HttpStatus.OK;
  }
}
