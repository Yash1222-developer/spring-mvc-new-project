package com.online.shopping.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.shopping.portal.dao.ProductDao;
import com.online.shopping.portal.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
    private ProductDao productDAO;
	
	@Override
	@Transactional
	public void saveProduct(Product product) {
		productDAO.save(product);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		productDAO.update(product);
	}

	@Override
	@Transactional
	public void deleteProduct(int productId) {
		Product product = productDAO.getById(productId);
        if(product != null) {
            productDAO.delete(product); // soft delete
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Product getProductById(int productId) {
		 return productDAO.getById(productId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> getAllProducts() {
		return productDAO.getAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> getAvailableProducts() {
		return productDAO.getAvailableProducts();
	}

}
