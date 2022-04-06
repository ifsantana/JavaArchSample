package internal.v1.commands.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewUser {
  private Long id;
  private String email;

  public NewUser(String email) {
    this.email = email;
  }
}
