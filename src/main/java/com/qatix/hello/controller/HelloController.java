package com.qatix.hello.controller;

import com.qatix.hello.entity.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final String template = "hello,%s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greet(@RequestParam(value = "name",defaultValue = "abc")String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping("/cors")
    public Greeting greet2(@RequestParam(value = "name",defaultValue = "abc")String name){
        System.out.println("=== in greeting ===");
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
