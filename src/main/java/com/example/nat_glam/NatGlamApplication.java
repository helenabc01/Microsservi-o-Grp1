package com.example.nat_glam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@ComponentScan(basePackages = { "com.example.nat_glam.validator", "com.example.nat_glam.user", "com.example.nat_glam.order"})
public class NatGlamApplication {

    public static void main(String[] args) {
        SpringApplication.run(NatGlamApplication.class, args);
    }

}
