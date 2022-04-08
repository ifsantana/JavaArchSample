package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public abstract class EventBase extends ApplicationEvent {

  public EventBase(Object source) {
    super(source);
  }
}
