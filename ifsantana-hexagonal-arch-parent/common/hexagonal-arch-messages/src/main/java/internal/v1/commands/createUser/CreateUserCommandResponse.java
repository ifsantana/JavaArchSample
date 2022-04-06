package internal.v1.commands.createUser;

import internal.v1.commands.models.NewUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserCommandResponse {
  private NewUser user;
}
