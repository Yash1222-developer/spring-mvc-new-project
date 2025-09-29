package com.online.shopping.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Landing page
    public String homePage() {
        return "home"; // home.jsp
    }
    
    @GetMapping("/home") // Optional, just in case
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about"; 
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact"; 
    }
}

