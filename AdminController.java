package com.online.shopping.portal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.online.shopping.portal.entity.Admin;
import com.online.shopping.portal.entity.Product;
import com.online.shopping.portal.service.AdminService;
import com.online.shopping.portal.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductService productService;

    // ================== ADMIN LOGIN ==================
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin-login"; // admin-login.jsp
    }

    @PostMapping("/login")
    public String loginAdmin(@ModelAttribute("admin") Admin loginAdmin, HttpSession session, Model model) {
        Admin dbAdmin = adminService.getByEmail(loginAdmin.getEmail());
        if (dbAdmin != null && dbAdmin.getPassword().equals(loginAdmin.getPassword())) {
            session.setAttribute("loggedAdmin", dbAdmin); // store in session
            return "redirect:/admin/dashboard";
        }
        model.addAttribute("error", "Invalid email or password!");
        return "admin-login";
    }

    // ================== ADMIN LOGOUT ==================
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }

    // ================== ADMIN DASHBOARD ==================
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Admin loggedAdmin = (Admin) session.getAttribute("loggedAdmin");
        if (loggedAdmin == null) {
            return "redirect:/admin/login"; // redirect if not logged in
        }
        model.addAttribute("products", productService.getAllProducts());
        return "admin-dashboard"; // admin-dashboard.jsp
    }

    // ================== ADMIN REGISTRATION ==================
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("admin", new Admin());
        // Fetch countries list from DB for dropdown
        // model.addAttribute("countries", countryService.getAll());
        return "admin-register"; // admin-register.jsp
    }

    @PostMapping("/register")
    public String saveAdmin(@ModelAttribute("admin") Admin admin,
                            @RequestParam("confirmPassword") String confirmPassword,
                            Model model,
                            HttpSession session) {

        // Email uniqueness check
        if (adminService.getByEmail(admin.getEmail()) != null) {
            model.addAttribute("error", "Email already exists!");
            return "admin-register";
        }

        // Password match validation
        if (!admin.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Password and Confirm Password do not match!");
            return "admin-register";
        }

        // Save admin with temporary OTP session (for email verification)
        String otp = adminService.generateOTP(); // service sends OTP to email
        session.setAttribute("tempAdmin", admin);
        session.setAttribute("otp", otp);

        return "admin-otp-verify"; // otp verification JSP page
    }

    // ================== OTP VERIFICATION ==================
    @PostMapping("/register/verify-otp")
    public String verifyOtp(@RequestParam("otp") String otpInput, HttpSession session, Model model) {
        String otp = (String) session.getAttribute("otp");
        Admin tempAdmin = (Admin) session.getAttribute("tempAdmin");

        if (otp != null && otp.equals(otpInput) && tempAdmin != null) {
            tempAdmin.setStatus("A");
            adminService.save(tempAdmin);

            session.removeAttribute("otp");
            session.removeAttribute("tempAdmin");

            return "redirect:/admin/login"; // OTP verified → redirect login
        }

        model.addAttribute("error", "Invalid OTP! Please try again.");
        return "admin-otp-verify";
    }

    // ================== PRODUCT ADD ==================
    @GetMapping("/product/add")
    public String addProductForm(HttpSession session, Model model) {
        Admin loggedAdmin = (Admin) session.getAttribute("loggedAdmin");
        if (loggedAdmin == null) {
            return "redirect:/admin/login";
        }
        model.addAttribute("product", new Product());
        return "admin-product-add"; // admin-product-add.jsp
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute("product") Product product, HttpSession session) {
        Admin loggedAdmin = (Admin) session.getAttribute("loggedAdmin");
        if (loggedAdmin == null) {
            return "redirect:/admin/login";
        }
        productService.saveProduct(product);
        return "redirect:/admin/dashboard";
    }

    // ================== AJAX: Get States by Country ==================
    @GetMapping("/getStates")
    @ResponseBody
    public List<?> getStatesByCountry(@RequestParam("countryId") int countryId) {
        // return stateService.getStatesByCountry(countryId);
        return null; // placeholder
    }

    // ================== AJAX: Get Districts by State ==================
    @GetMapping("/getDistricts")
    @ResponseBody
    public List<?> getDistrictsByState(@RequestParam("stateId") int stateId) {
        // return districtService.getDistrictsByState(stateId);
        return null; // placeholder
    }
}
