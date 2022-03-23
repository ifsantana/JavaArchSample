package com.ifsantana.hexagonalarchapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.hateoas.support.WebStack;

@SpringBootApplication
@EnableHypermediaSupport(type = HypermediaType.HAL, stacks = WebStack.WEBMVC)
public class HexagonalArchApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(HexagonalArchApiApplication.class, args);
  }
}
