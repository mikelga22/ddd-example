package com.example.ddd.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.example.ddd")
public class DddExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddExampleApplication.class, args);
    }

}
