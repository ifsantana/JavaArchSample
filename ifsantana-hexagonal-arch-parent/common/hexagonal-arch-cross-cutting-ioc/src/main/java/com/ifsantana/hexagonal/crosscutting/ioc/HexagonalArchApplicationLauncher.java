package com.ifsantana.hexagonal.crosscutting.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HexagonalArchApplicationLauncher {
  public static void main(String[] args) {
    SpringApplication.run(HexagonalArchApplicationLauncher.class, args);
  }
}
