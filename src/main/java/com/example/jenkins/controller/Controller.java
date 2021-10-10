package com.example.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/test")
    public String test() {
        return "hiss";
    }

    @GetMapping("/test2")
    public String test2() {
        return "hiss2ss";
    }
}
