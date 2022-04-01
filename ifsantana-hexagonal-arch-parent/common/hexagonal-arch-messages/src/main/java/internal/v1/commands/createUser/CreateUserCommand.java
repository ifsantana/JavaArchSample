package internal.v1.commands.createUser;

import com.ifsantana.hexagonal.crosscutting.bus.CommandBase;
import internal.v1.commands.models.NewUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserCommand extends CommandBase {
  private NewUser user;

  public CreateUserCommand(NewUser source) {
    super(source);
    this.user = source;
  }
}
