package com.online.shopping.portal.controller;

import com.online.shopping.portal.entity.Product;
import com.online.shopping.portal.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    private List<Product> cartItems = new ArrayList<>();

    // --- Show Cart ---
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartList", cartItems);
        return "cart";
    }
    
 // --- Show Checkout Page ---
    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("cartList", cartItems); // cart ke items JSP me show karne ke liye
        return "checkout"; // checkout.jsp render hoga
    }


    // --- Add Product to Cart ---
    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("productId") int productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            boolean exists = false;
            for (Product p : cartItems) {
                if (p.getProductId() == productId) {
                    p.setQuantity(p.getQuantity() + 1);
                    p.setTotal(p.getPrice() * p.getQuantity());
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                product.setQuantity(1);
                product.setTotal(product.getPrice() * product.getQuantity());
                cartItems.add(product);
            }
        }
        return "redirect:/cart";
    }

    // --- Remove Product from Cart ---
    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam("productId") int productId) {
        cartItems.removeIf(p -> p.getProductId() == productId);
        return "redirect:/cart";
    }
}
