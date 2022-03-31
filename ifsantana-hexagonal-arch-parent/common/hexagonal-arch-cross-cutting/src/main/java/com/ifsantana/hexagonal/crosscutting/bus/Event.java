package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;

public class Event extends ApplicationEvent {

  public Event(Object source) {
    super(source);
  }
}
