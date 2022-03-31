package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class InMemoryBus {

  private final ApplicationEventPublisher applicationEventPublisher;

  public InMemoryBus(
      ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public void publishEvent(ApplicationEvent event) {
    this.applicationEventPublisher.publishEvent(event);
  }
}
