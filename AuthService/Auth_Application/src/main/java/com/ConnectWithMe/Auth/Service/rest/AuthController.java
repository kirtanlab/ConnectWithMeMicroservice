package com.ConnectWithMe.Auth.Service.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Auth/v1/api", produces = "application/vnd.api.v1+json")
public class AuthController {

    @GetMapping
    public ResponseEntity<?> hello()
    {
        System.out.println("in hello");
        return ResponseEntity.ok("hello");
    }
}
