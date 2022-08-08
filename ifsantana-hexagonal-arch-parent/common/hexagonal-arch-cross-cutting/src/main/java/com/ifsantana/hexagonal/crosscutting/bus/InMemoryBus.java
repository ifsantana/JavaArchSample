package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public interface InMemoryBus {
  void publishEvent(ApplicationEvent event);
}
