package com.online.shopping.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shopping.portal.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Admin admin) {
		admin.setStatus("A");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(admin);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Admin admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(admin);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Admin admin) {
		admin.setStatus("C");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(admin);
		tx.commit();
		session.close();
	}

	@Override
	public Admin getById(int id) {
		Session session = sessionFactory.openSession();
		Admin admin = session.createQuery("from Admin where id=:id and status = 'A'", Admin.class)
				             .setParameter("id", id)
				             .uniqueResult();
		session.close();
		return admin;
	}

	@Override
	public List<Admin> getAll() {
		Session session = sessionFactory.openSession();
		List<Admin> admins = session.createQuery("from Admin where status = 'A'", Admin.class).list();
		session.close();
		return admins;
	}

	@Override
	public Admin getByEmail(String email) {
		Session session = sessionFactory.openSession();
	    Admin admin = session.createQuery("from Admin where email=:email and status = 'A'", Admin.class)
				                 .setParameter("email", email)
				                 .uniqueResult();
	    session.close();
		return admin;
	}

}
