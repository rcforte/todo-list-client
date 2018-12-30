package com.rcforte.todolistclient;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@Log
public class TodoListClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoListClientApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  CommandLineRunner clr(RouteLocator routeLocator) {
    return args -> routeLocator.getRoutes().forEach(r -> {
      log.info(String.format("%s (%s) %s", r.getId(), r.getLocation(), r.getFullPath()));
    });
  }
}

