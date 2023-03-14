package com.ifsantana.hexagonal.adapters.mongodb.config.mongock;

import io.mongock.runner.spring.base.events.SpringMigrationStartedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class MongockStartedEventListener implements
    ApplicationListener<SpringMigrationStartedEvent> {

  private static final Logger log = LoggerFactory.getLogger(MongockStartedEventListener.class);

  @Override
  public void onApplicationEvent(SpringMigrationStartedEvent event) {
    log.debug("[EVENT LISTENER] - Mongock STARTED successfully. {}", event);
  }
}