package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@FunctionalInterface
public interface EventHandler<TEvent extends ApplicationEvent>
    extends ApplicationListener<TEvent>  {

  @Override
  void onApplicationEvent(TEvent event);
}
