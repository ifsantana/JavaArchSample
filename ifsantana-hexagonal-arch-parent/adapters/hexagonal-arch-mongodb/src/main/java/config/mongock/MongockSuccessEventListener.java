package config.mongock;

import io.mongock.runner.spring.base.events.SpringMigrationSuccessEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class MongockSuccessEventListener implements
    ApplicationListener<SpringMigrationSuccessEvent> {

  private static final Logger log = LoggerFactory.getLogger(MongockSuccessEventListener.class);

  @Override
  public void onApplicationEvent(SpringMigrationSuccessEvent event) {
    log.info("[EVENT LISTENER] - Mongock finished successfully: {}", event);
  }
}
