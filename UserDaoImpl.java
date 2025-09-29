package com.online.shopping.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shopping.portal.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	@Override
	public void save(User user) {
		user.setStatus("A");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
	}

	@Override
	public void delete(User user) {
		user.setStatus("C");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
	}

	@Override
	public User getById(int id) {
		Session session = sessionFactory.openSession();
        User user = session.createQuery("from User where id=:id and status='A'", User.class)
                           .setParameter("id", id)
                           .uniqueResult();
        session.close();
        return user;
	}

	@Override
	public List<User> getAll() {
		Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User where status='A'", User.class).list();
        session.close();
        return users;
	}

	@Override
	public User getByEmail(String email) {
		 Session session = sessionFactory.openSession();
	     User user = session.createQuery("from User where email=:email and status='A'", User.class)
	                           .setParameter("email", email)
	                           .uniqueResult();
	     session.close();
	     return user;
	}

}
