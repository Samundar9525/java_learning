package com.microlearning.javaMicroLearning.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class routes {

    @GetMapping("/hr")
    @PreAuthorize("hasRole('HR')")
    public String hrDashboard() {
        return "Welcome to the HR Dashboard!";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('Manager')")
    public String managerDashboard() {
        return "Welcome to the Manager Dashboard!";
    }

    @GetMapping("/engineer")
    @PreAuthorize("hasRole('Employee')")
    public String engineerDashboard() {
        return "Welcome to the Engineer Dashboard!";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public dashboard endpoint accessible to all.";
    }
}
