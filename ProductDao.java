package com.online.shopping.portal.dao;

import java.util.List;

import com.online.shopping.portal.entity.Product;

public interface ProductDao extends GenericDAO<Product> {
	
	List<Product> getAvailableProducts();

}
