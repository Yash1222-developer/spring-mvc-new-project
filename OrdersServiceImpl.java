package com.online.shopping.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.shopping.portal.dao.OrderDao;
import com.online.shopping.portal.entity.Orders;

@Service
public class OrdersServiceImpl implements OrderService {
	
	@Autowired
    private OrderDao ordersDAO;

	@Override
	@Transactional
	public void saveOrder(Orders order) {
		ordersDAO.save(order);
	}

	@Override
	@Transactional
	public void updateOrder(Orders order) {
		ordersDAO.update(order);
	}

	@Override
	@Transactional
	public void deleteOrder(int orderId) {
		Orders order = ordersDAO.getById(orderId);
        if(order != null) {
            ordersDAO.delete(order);
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Orders getOrderById(int orderId) {
		return ordersDAO.getById(orderId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Orders> getAllOrders() {
		return ordersDAO.getAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Orders> getOrdersByUserId(int userId) {
		return ordersDAO.getOrdersByUserId(userId);
	}

}
