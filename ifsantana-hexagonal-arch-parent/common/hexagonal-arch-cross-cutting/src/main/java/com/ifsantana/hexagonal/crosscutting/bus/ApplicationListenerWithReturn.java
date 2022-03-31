package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public interface ApplicationListenerWithReturn<TRequest extends ApplicationEvent, TResponse> {

  /**
   * Handle an application event.
   * @param event the event to respond to
   */
  @EventListener
  TResponse handle(TRequest event);
}