package internal.v1.commands;

import internal.v1.commands.models.NewUser;
import org.springframework.context.ApplicationEvent;

public class CreateUserCommand extends ApplicationEvent {
    private NewUser user;

  public CreateUserCommand(Object source, NewUser user) {
    super(source);
    this.user = user;
  }
}
