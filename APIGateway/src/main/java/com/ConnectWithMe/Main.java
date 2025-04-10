package com.ConnectWithMe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ConnectWithMe"})
@EnableDiscoveryClient
public class Main {
    public static void main(String[] args) {
        System.out.println("nnn");
        SpringApplication.run(Main.class, args);
    }
}