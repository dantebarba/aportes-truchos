package com.github.dantebarba.aportestruchos.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.github.dantebarba.mapadeldelito")
@EnableAutoConfiguration
@EntityScan(basePackages={"com.github.dantebarba.mapadeldelito.domain"})
@EnableJpaRepositories(basePackages={"com.github.dantebarba.mapadeldelito.repositories"})
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
