package internal.v1.commands.deleteUser;

import com.ifsantana.hexagonal.crosscutting.bus.CommandBase;
import internal.v1.commands.models.NewUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteUserCommand extends CommandBase {
  private NewUser user;

  public DeleteUserCommand(NewUser source) {
    super(source);
    this.user = source;
  }
}
