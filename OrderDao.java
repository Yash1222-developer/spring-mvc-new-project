package com.online.shopping.portal.dao;

import java.util.List;

import com.online.shopping.portal.entity.Orders;

public interface OrderDao extends GenericDAO<Orders> {
	
	List<Orders> getOrdersByUserId(int userId);
	
}
