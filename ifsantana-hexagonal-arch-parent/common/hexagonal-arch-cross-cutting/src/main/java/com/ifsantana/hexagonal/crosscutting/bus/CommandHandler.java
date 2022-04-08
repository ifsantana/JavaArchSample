package com.ifsantana.hexagonal.crosscutting.bus;

import org.springframework.context.ApplicationEvent;

@FunctionalInterface
public interface CommandHandler<TCommand extends ApplicationEvent, TResult> extends
    ApplicationListenerWithReturn<TCommand, TResult> {

  @Override
  TResult handle(TCommand event);
}