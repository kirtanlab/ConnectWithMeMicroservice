package com.ConnectWithMe;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.ConnectWithMe.Controllers",
        "com.ConnectWithMe.Domain.ports.input.service",
        "com.ConnectWithMe.Domain.ports.output.Repository",
        "com.ConnectWithMe.Domain.ports.output.message.publisher",
        "com.ConnectWithMe.DataAccess.adapter",
        "com.ConnectWithMe.Auth_DataAccess.adapter",
        "com.ConnectWithMe.Users.adapter",
        "com.ConnectWithMe.Users.mapper",
        "com.ConnectWithMe.Auth_Domain.Auth_Application_Service.Repository",
        "com.ConnectWithMe.Auth_Domain.Auth_Application_Service.message.publisher",
        "com.ConnectWithMe.publisher.kafka",
        "com.ConnectWithMe.kafka.service",
        "com.ConnectWithMe.kafka.config.data",
        "com.ConnectWithMe.Domain.config",
        "com.ConnectWithMe.config"
})
@EnableDiscoveryClient
public class Main {
    public static void main(String[] args) {
         SpringApplication.run(Main.class, args);
    }
}