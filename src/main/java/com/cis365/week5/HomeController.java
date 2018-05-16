package com.cis365.week5;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }
}
