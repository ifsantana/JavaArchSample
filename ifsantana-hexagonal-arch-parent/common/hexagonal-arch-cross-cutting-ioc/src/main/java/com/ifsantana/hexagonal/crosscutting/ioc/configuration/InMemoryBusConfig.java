package com.ifsantana.hexagonal.crosscutting.ioc.configuration;

import com.ifsantana.hexagonal.crosscutting.bus.InMemoryBus;
import com.ifsantana.hexagonal.crosscutting.bus.InMemoryBusImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryBusConfig {

  @Bean
  public InMemoryBus inMemoryBus() {
    return new InMemoryBusImpl();
  }
}
