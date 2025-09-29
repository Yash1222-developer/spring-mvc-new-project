package com.online.shopping.portal.dao;

import com.online.shopping.portal.entity.Admin;

public interface AdminDao extends GenericDAO<Admin> {
	
	void save(Admin admin);
	
	Admin getByEmail(String email); // extra method
}
