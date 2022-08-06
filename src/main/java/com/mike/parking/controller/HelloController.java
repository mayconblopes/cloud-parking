package com.mike.parking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore // esta anotação diz que este controller não vai aparecer no Swagger
@RestController
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello, Spring! Mike here!.";
    }
}
