package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public abstract class CommandBase extends ApplicationEvent {

  public CommandBase(Object source) {
    super(source);
  }
}
