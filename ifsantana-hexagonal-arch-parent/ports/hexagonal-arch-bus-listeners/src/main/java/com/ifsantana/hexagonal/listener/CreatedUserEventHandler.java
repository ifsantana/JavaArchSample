package com.ifsantana.hexagonal.listener;

import com.ifsantana.hexagonal.crosscutting.bus.EventHandler;
import external.v1.events.UserCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class CreatedUserEventHandler implements EventHandler<UserCreatedEvent> {

  @Override
  public void onApplicationEvent(UserCreatedEvent event) {
    System.out.println("Received event. " + event.getClass().getSimpleName());
  }
}
