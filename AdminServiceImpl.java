package com.online.shopping.portal.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.portal.dao.AdminDao;
import com.online.shopping.portal.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public void save(Admin admin) {
		adminDao.save(admin);
	}

	@Override
	public void update(Admin admin) {
		adminDao.update(admin);
	}

	@Override
	public void delete(Admin admin) {
		adminDao.delete(admin);
	}

	@Override
	public Admin getById(int id) {
		return adminDao.getById(id);
	}

	@Override
	public List<Admin> getAll() {
		return adminDao.getAll();
	}

	@Override
	public Admin getByEmail(String email) {
		return adminDao.getByEmail(email);
	}
	
	 @Override
	    public String generateOTP() {
	        Random r = new Random();
	        int otp = 100000 + r.nextInt(900000); // 6-digit OTP
	        return String.valueOf(otp);
	    }

}
