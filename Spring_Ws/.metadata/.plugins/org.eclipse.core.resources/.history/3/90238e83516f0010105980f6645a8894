package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "home"; // This will map to /WEB-INF/home.jsp
    }
    @GetMapping("/test")
    public String testPage() {
        return "test"; // Resolves to /WEB-INF/test.jsp
    }
}
