package com.microlearning.javaMicroLearning.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.saveUser(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        User user = userService.findByUsername(request.getUsername());

        // Get roles as a Set<String>
        Set<String> roles = user.getRoles().stream()
                .map(Role::getRole)
                .collect(Collectors.toSet());

        // ❗ Use the first role (if only one is expected per user)
        String role = roles.iterator().next();  // Get the first role
        role = role.replaceAll("[\\[\\]\"]", ""); // Just in case

        // ✅ Generate token with cleaned role string
        final String token = jwtUtil.generateToken(user.getUsername(), role);

        return new AuthenticationResponse(token);
    }
}
