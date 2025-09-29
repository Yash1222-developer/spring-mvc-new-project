package com.online.shopping.portal.controller;

import com.online.shopping.portal.entity.User;
import com.online.shopping.portal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
	
	 @Autowired
	    private UserService userService;

	    // Show registration form
	    @GetMapping("/register")
	    public String showRegisterForm(Model model) {
	        model.addAttribute("user", new User());
	        return "user-register"; // user-register.jsp
	    }

	    // Save user
	    @PostMapping("/save")
	    public String saveUser(@ModelAttribute("user") User user) {
	        user.setStatus("A");
	        userService.saveUser(user);
	        return "redirect:/login";
	    }

	    // Login form
	    @GetMapping("/login")
	    public String showLoginForm(Model model) {
	        model.addAttribute("user", new User());
	        return "user-login"; // user-login.jsp
	    }

	    // Login validation
	    @PostMapping("/login")
	    public String loginUser(@ModelAttribute("user") User loginUser, Model model) {
	        User dbUser = userService.getUserByEmail(loginUser.getEmail());
	        if (dbUser != null && dbUser.getPassword().equals(loginUser.getPassword())) {
	            model.addAttribute("user", dbUser);
	            return "redirect:/products"; // successful login → product page
	        }
	        model.addAttribute("error", "Invalid email or password!");
	        return "user-login";
	    }

}
