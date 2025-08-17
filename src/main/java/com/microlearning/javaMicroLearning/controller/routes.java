package com.microlearning.javaMicroLearning.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class routes {
    @RequestMapping ("/dashboard")
    public String dahboard() {
        String text = "This is the dashboard Private Page";
        return text;
    }
}
