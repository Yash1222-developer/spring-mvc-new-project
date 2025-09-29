package com.online.shopping.portal.controller;

import com.online.shopping.portal.entity.Orders;
import com.online.shopping.portal.entity.Product;
import com.online.shopping.portal.service.OrderService;
import com.online.shopping.portal.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
    private OrderService ordersService;

    @Autowired
    private ProductService productService;
    
 // Show all orders
    @GetMapping
    public String listOrders(Model model) {
        List<Orders> orders = ordersService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order-list"; // order-list.jsp
    }

    // Place order
    @PostMapping("/place/{productId}")
    public String placeOrder(@PathVariable("productId") int productId,
                             @RequestParam("quantity") int quantity) {
        Product product = productService.getProductById(productId);

        if (product != null && product.getStock() >= quantity) {
            Orders order = new Orders();
            order.setProductId(productId);
            order.setQuantity(quantity);
            order.setTotalPrice(product.getPrice() * quantity);
            order.setOrderDate(LocalDateTime.now());
            order.setStatus("A");

            // Save order
            ordersService.saveOrder(order);

            // Reduce stock
            product.setStock(product.getStock() - quantity);
            productService.updateProduct(product);
        }

        return "redirect:/orders";
    }

    // Cancel order (soft delete)
    @GetMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable("id") int orderId) {
        ordersService.deleteOrder(orderId);
        return "redirect:/orders";
    }

}
