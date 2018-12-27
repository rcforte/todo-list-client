package com.rcforte.todolistclient;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@Log
public class TodoListClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoListClientApplication.class, args);
  }

  @Bean
  CommandLineRunner clr(RouteLocator routeLocator) {
    return args -> routeLocator.getRoutes().forEach(r -> {
      log.info(String.format("%s (%s) %s", r.getId(), r.getLocation(), r.getFullPath()));
    });
  }
}

