package com.xapp.xjava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/test")
    String testx() {
        return "Hello Java!";
    }
}
