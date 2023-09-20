package com.ifsantana.hexagonalarchapi.controllers.user.v1;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.ifsantana.hexagonal.application.handlers.commands.CreateUserCommandHandler;
import com.ifsantana.hexagonal.crosscutting.bus.CommandHandler;
import com.ifsantana.hexagonalarchapi.controllers.user.v1.requests.CreateUserRequest;
import com.ifsantana.hexagonalarchapi.controllers.user.v1.requests.UpdateUserRequest;
import com.ifsantana.hexagonalarchapi.controllers.user.v1.responses.GetUserResponse;
import internal.v1.commands.createUser.CreateUserCommand;
import internal.v1.commands.createUser.CreateUserCommandResponse;
import internal.v1.commands.deleteUser.DeleteUserCommand;
import internal.v1.commands.models.NewUser;
import io.swagger.v3.oas.annotations.Operation;
import io.vavr.Tuple2;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor.AnyAnnotation;
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
@AllArgsConstructor
public class UserControllerV1 {
  private Map<String, CommandHandler> handlers;

  @Operation(operationId = "get-users", tags = {"users"})
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpStatus getUsers() {
    return HttpStatus.OK;
  }

  @Operation(operationId = "get-users", tags = {"users"})
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getUser(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(new GetUserResponse());
  }

  @Operation(operationId = "create-user", tags = {"users"})
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity createUser(@RequestBody CreateUserRequest request) throws URISyntaxException {

    var createdUser = (Tuple2<Boolean, CreateUserCommandResponse>) this.handlers.get(CreateUserCommand.class.getSimpleName()).handle(new CreateUserCommand(new NewUser(request.getEmail())));

    if(createdUser._1()) {
      return ResponseEntity.status(HttpStatus.CREATED)
          .location(new URI(linkTo(UserControllerV1.class)
              .slash(createdUser._2().getUser().getId()).withSelfRel()
              .getHref()))
          .body(createdUser._2().getUser());
    }
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
  }

  @Operation(operationId = "update-user", tags = {"users"})
  @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpStatus updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
    return HttpStatus.OK;
  }

  @Operation(operationId = "delete-user", tags = {"users"})
  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpStatus deleteUser(@PathVariable Long id) {
    this.handlers.get(DeleteUserCommand.class.getSimpleName()).handle(new DeleteUserCommand(new NewUser(id)));
    return HttpStatus.OK;
  }
}
