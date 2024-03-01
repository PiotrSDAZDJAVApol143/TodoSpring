package com.example.listazadanspring;

import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@EnableAsync   //włącznik do Async
@SpringBootApplication
public class ListaZadanSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListaZadanSpringApplication.class, args);
    }

  @Bean
  Validator validator(){
      return new LocalValidatorFactoryBean();
   }
}
