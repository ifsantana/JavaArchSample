package config.mongock;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import io.mongock.api.config.MongockConfiguration;
import io.mongock.driver.mongodb.springdata.v3.SpringDataMongoV3Driver;
import io.mongock.runner.springboot.EnableMongock;
import io.mongock.runner.springboot.MongockSpringboot;
import io.mongock.runner.springboot.base.MongockInitializingBeanRunner;
import java.util.List;
import migrations.InitializerSystemMigration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;

@EnableMongock
@Configuration
public class MongockConfig {

  @Value("${config.mongock.is-enabled}")
  private Boolean isEnabled;

  @Value("${config.mongock.read-concern}")
  private ReadConcern readConcern;

  @Value("${config.mongock.start-system-version}")
  private String startSystemVersion;

  @Value("${config.mongock.end-system-version}")
  private String endSystemVersion;

  @Value("${config.mongock.migration-scan-package}")
  private String migrationScanPackages;

  @Value("${config.mongock.migration-repository-name}")
  private String migrationRepositoryName;

  @Value("${config.mongock.lock-repository-name}")
  private String lockRepositoryName;

  @Value("${config.mongock.track-ignored}")
  private boolean trackIgnored;

  @Value("${config.mongock.transaction-enabled}")
  private boolean transactionEnabled;

  @Bean
  public MongockInitializingBeanRunner mongockApplicationRunner(
      ApplicationContext springContext,
      ApplicationEventPublisher eventPublisher,
      MongoTemplate mongoTemplate) {

    return MongockSpringboot.builder()
        .setConfig(getConfiguration())
        .setDriver(configureMongodbDriver(mongoTemplate))
        .setEventPublisher(eventPublisher)
        .setSpringContext(springContext)
        .buildInitializingBeanRunner();
  }

  /**
   * Transaction Manager.
   * Needed to allow execution of changeSets in transaction scope.
   * Only for primary MongoTemplate.
   */
  @Bean
  public MongoTransactionManager transactionManager(MongoTemplate mongoTemplate) {
    ReadConcern readConcern = this.readConcern;
    TransactionOptions transactionalOptions = TransactionOptions.builder()
        .readConcern(readConcern)
        .readPreference(ReadPreference.primary())
        .writeConcern(WriteConcern.MAJORITY.withJournal(true))
        .build();
    return new MongoTransactionManager(mongoTemplate.getMongoDbFactory(), transactionalOptions);
  }

  private MongockConfiguration getConfiguration() {
    var config = new MongockConfiguration();
    config.setEnabled(this.isEnabled);
    config.setMigrationScanPackage(List.of(InitializerSystemMigration.class.getPackage().getName()));
    config.setMigrationRepositoryName(this.migrationRepositoryName);
    config.setLockRepositoryName(this.lockRepositoryName);
    config.setTrackIgnored(this.trackIgnored);
    return config;
  }

  private SpringDataMongoV3Driver configureMongodbDriver(MongoTemplate mongoTemplate) {
    var driver = SpringDataMongoV3Driver.withDefaultLock(mongoTemplate);
    driver.setReadConcern(this.readConcern);
    driver.setReadPreference(ReadPreference.primary());
    if(this.transactionEnabled) {
      driver.enableTransactionWithTxManager(this.transactionManager(mongoTemplate));
      driver.enableTransaction();
    } else {
      driver.setWriteConcern(WriteConcern.MAJORITY.withJournal(false));
    }
    return driver;
  }
}
