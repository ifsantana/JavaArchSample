package com.ifsantana.hexagonal.crosscutting.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.hateoas.support.WebStack;

@SpringBootApplication(scanBasePackages = "com.ifsantana.*")
@EnableHypermediaSupport(type = HypermediaType.HAL, stacks = WebStack.WEBMVC)
public class HexagonalArchApplicationLauncher {
  public static void main(String[] args) {
    SpringApplication.run(HexagonalArchApplicationLauncher.class, args);
  }
}
