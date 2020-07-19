package com.fifthProject.fifthProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("index")
    public String getIndex() {
        return "index";
    }
}
