package internal.v1.commands;

import internal.v1.commands.models.NewUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class CreateUserCommand extends ApplicationEvent {
  private NewUser user;

  public CreateUserCommand(Object source, NewUser user) {
    super(source);
    this.user = user;
  }
}
