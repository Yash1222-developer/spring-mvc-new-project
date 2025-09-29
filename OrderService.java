package com.online.shopping.portal.service;

import java.util.List;

import com.online.shopping.portal.entity.Orders;

public interface OrderService {
	
	void saveOrder(Orders order);
	
    void updateOrder(Orders order);
    
    void deleteOrder(int orderId);
    
    Orders getOrderById(int orderId);
    
    List<Orders> getAllOrders();
    
    List<Orders> getOrdersByUserId(int userId);

}
