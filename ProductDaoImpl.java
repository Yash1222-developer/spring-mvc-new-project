package com.online.shopping.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shopping.portal.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	 @Autowired
	 private SessionFactory sessionFactory;

	@Override
	public void save(Product product) {
		product.setStatus("A"); // Active
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();		
	}

	@Override
	public void update(Product product) {
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(product);
        tx.commit();
        session.close();
	}

	@Override
	public void delete(Product product) {
		 product.setStatus("C"); // Cancelled / soft delete
	     Session session = sessionFactory.openSession();
	     Transaction tx = session.beginTransaction();
	     session.update(product);
	     tx.commit();
	     session.close();
	}

	@Override
	public Product getById(int id) {
		Session session = sessionFactory.openSession();
        Product product = session.createQuery("from Product where id=:id and status='A'", Product.class)
                                 .setParameter("id", id)
                                 .uniqueResult();
        session.close();
        return product;
	}

	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.openSession();
        List<Product> products = session.createQuery("from Product where status='A'", Product.class).list();
        session.close();
        return products;

	}

	@Override
	public List<Product> getAvailableProducts() {
		 Session session = sessionFactory.openSession();
	     List<Product> products = session.createQuery("from Product where stock>0 and status='A'", Product.class).list();
	     session.close();
	     return products;
	}

}
