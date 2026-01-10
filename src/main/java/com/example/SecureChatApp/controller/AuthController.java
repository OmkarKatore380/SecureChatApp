package com.example.SecureChatApp.controller;

import com.example.SecureChatApp.entities.User;
import com.example.SecureChatApp.repository.UserRepository;
import com.example.SecureChatApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        try {
            User newUser = userService.registerUser(request.get("password"), request.get("name"));
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<Map<String, String>>> getAllUsers() {
        List<Map<String, String>> userList = userRepository.findAll().stream()
            .map(u -> {
                Map<String, String> m = new HashMap<>();
                m.put("id", u.getMilitaryId());
                m.put("name", u.getDisplayName());
                return m;
            }).collect(Collectors.toList());
        return ResponseEntity.ok(userList);
    }
}