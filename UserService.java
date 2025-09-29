package com.online.shopping.portal.service;

import java.util.List;

import com.online.shopping.portal.entity.User;

public interface UserService {
	
	void saveUser(User user);
	
    void updateUser(User user);
    
    void deleteUser(int userId);
    
    User getUserById(int userId);
    
    List<User> getAllUsers();
    
    User getUserByEmail(String email);

}
