package com.example.first_spring_boot_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class AppController {
    @GetMapping("/")
    public String showHomePage() {
        return "home"; // This will map to /templates/home.jsp
    }
    @GetMapping("/test")
    public String testPage() {
        return "test"; // Resolves to /templates/test.jsp
    }
    @PostMapping("/login")
    public String loginValidate(@RequestParam String uname, @RequestParam String psw) {
    	System.out.println(" inside login Validate "+uname+" "+psw);
    	if(uname.equalsIgnoreCase("admin") && psw.equalsIgnoreCase("123")) {   
    		System.out.println(" user credentials is correct");
    		return "dashboard";
    	}else {
    		System.out.println(" user credentials is not correct");
        	
    		return "home";
    	}
    }
 
}
