package external.v1.events;

import com.ifsantana.hexagonal.crosscutting.bus.EventBase;
import internal.v1.commands.models.NewUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreatedEvent extends EventBase {
  private Long id;
  private String email;

  public UserCreatedEvent(NewUser source) {
    super(source);
    this.id = source.getId();
    this.email = source.getEmail();
  }
}
