package com.ifsantana.hexagonal.adapters.mongodb.config.mongock;

import io.mongock.runner.spring.base.events.SpringMigrationFailureEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class MongockFailEventListener implements
    ApplicationListener<SpringMigrationFailureEvent> {

  private static final Logger log = LoggerFactory.getLogger(MongockFailEventListener.class);

  @Override
  public void onApplicationEvent(SpringMigrationFailureEvent event) {
    log.debug("[EVENT LISTENER] - Mongock finished with failures: {}", event.getMigrationResult());
  }
}
