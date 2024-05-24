package com.ConnectWithMe.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Feed/v1/api/")
public class FeedController {
    @GetMapping
    public String Test(){
        return "Hello";
    }

    @GetMapping("jwtTester")
    public String Tester(){
        return "Done";
    }
}
