package com.oziii.store.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.oziii.store")
public class StoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApiApplication.class, args);
    }

}
