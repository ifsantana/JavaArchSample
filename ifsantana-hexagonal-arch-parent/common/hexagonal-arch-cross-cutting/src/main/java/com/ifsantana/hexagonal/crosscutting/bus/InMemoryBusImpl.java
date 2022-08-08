package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class InMemoryBusImpl implements InMemoryBus {

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void publishEvent(ApplicationEvent event) {
    this.applicationEventPublisher.publishEvent(event);
  }
}
