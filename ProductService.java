package com.online.shopping.portal.service;

import java.util.List;

import com.online.shopping.portal.entity.Product;

public interface ProductService {
	
	void saveProduct(Product product);
	
    void updateProduct(Product product);
    
    void deleteProduct(int productId); // soft delete
    
    Product getProductById(int productId);
    
    List<Product> getAllProducts();
    
    List<Product> getAvailableProducts();

}
