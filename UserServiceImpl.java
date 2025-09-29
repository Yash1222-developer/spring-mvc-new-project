package com.online.shopping.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.shopping.portal.dao.UserDao;
import com.online.shopping.portal.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserDao userDAO;
	
	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.save(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.update(user);
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		 User user = userDAO.getById(userId);
	      if(user != null) {
	          userDAO.delete(user);
	      }
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(int userId) {
		return userDAO.getById(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return userDAO.getAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserByEmail(String email) {
		return userDAO.getByEmail(email);
	}

}
