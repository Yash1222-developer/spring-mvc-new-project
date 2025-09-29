package com.online.shopping.portal.dao;

import com.online.shopping.portal.entity.User;

public interface UserDao extends GenericDAO<User> {
	User getByEmail(String email);
}
