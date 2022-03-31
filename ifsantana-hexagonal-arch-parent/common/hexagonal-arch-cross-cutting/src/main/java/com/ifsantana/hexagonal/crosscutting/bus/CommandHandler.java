package com.ifsantana.hexagonal.crosscutting.bus;

import java.util.EventListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

@Service
public interface CommandHandler<TCommand extends ApplicationEvent, TResult> extends EventListener {
  TResult onApplicationCommand(TCommand command);
}
