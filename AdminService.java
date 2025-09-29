package com.online.shopping.portal.service;

import java.util.List;

import com.online.shopping.portal.entity.Admin;

public interface AdminService {
	
	void save(Admin admin);
	
	void update(Admin admin);
	
	void delete(Admin admin);
	
	Admin getById(int id);
	
	List<Admin> getAll();
	
	Admin getByEmail(String email);
	
	String generateOTP();
}
