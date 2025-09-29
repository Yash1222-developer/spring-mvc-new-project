package com.online.shopping.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shopping.portal.entity.Orders;

@Repository
public class OrdersDaoImpl implements OrderDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void save(Orders order) {
		order.setStatus("A");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(order);
        tx.commit();
        session.close();
	}

	@Override
	public void update(Orders order) {
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(order);
        tx.commit();
        session.close();
	}

	@Override
	public void delete(Orders order) {
		order.setStatus("C");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(order);
        tx.commit();
        session.close();
	}

	@Override
	public Orders getById(int id) {
		Session session = sessionFactory.openSession();
        Orders order = session.createQuery("from Orders where id=:id and status='A'", Orders.class)
                              .setParameter("id", id)
                              .uniqueResult();
        session.close();
        return order;
	}

	@Override
	public List<Orders> getAll() {
		Session session = sessionFactory.openSession();
        List<Orders> orders = session.createQuery("from Orders where status='A'", Orders.class).list();
        session.close();
        return orders;
	}

	@Override
	public List<Orders> getOrdersByUserId(int userId) {
		Session session = sessionFactory.openSession();
        List<Orders> orders = session.createQuery("from Orders where productId=:userId and status='A'", Orders.class)
                                     .setParameter("userId", userId)
                                     .list();
        session.close();
        return orders;
	}

}
