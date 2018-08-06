package com.s3s.finalProject.service;

import com.s3s.finalProject.entity.Users;

public interface UserService {

	Users findByUsername(String username);
	Users findByEmail(String email);
	
	Users findByUserId(Long userId);
	
	boolean checkCustomerExists(String username, String email);
	
	boolean checkUsernameExists(String username);
	
	boolean checkEmailExists(String email);
	
	void save(Users user);
	
	Users login(String username, String password);
}
