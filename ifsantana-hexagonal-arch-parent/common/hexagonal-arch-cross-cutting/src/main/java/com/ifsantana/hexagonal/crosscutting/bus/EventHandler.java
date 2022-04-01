package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public abstract class EventHandler<TEvent extends ApplicationEvent>
    implements ApplicationListener<TEvent>  {

  @Override
  public void onApplicationEvent(TEvent event) { }
}
