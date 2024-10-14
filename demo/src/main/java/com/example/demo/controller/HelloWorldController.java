package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloWorldController
 * Package: com.example.demo.controller
 * Description:
 *
 * @Author 毕研政
 * @Create 2024/10/14 22:46
 * @Version 1.0
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
}
