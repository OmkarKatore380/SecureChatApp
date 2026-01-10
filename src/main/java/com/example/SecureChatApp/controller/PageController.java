package com.example.SecureChatApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class PageController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; 
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/chat")
    public String chatPage(Principal principal, Model model) {
        // Pass the logged-in Military ID to the HTML page
        if (principal != null) {
            model.addAttribute("myMilitaryId", principal.getName());
        }
        return "chat";
    }
}