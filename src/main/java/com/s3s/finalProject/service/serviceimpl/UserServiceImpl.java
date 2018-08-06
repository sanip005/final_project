package com.s3s.finalProject.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s3s.finalProject.entity.Users;
import com.s3s.finalProject.repository.UserRepo;
import com.s3s.finalProject.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepo userRepo;
	
	public void save(Users user) {
		userRepo.save(user);
	}

	@Override
	public Users findByUsername(String username) {
	
		return userRepo.findByUsername(username);
	}

	@Override
	public Users findByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}

	@Override
	public boolean checkCustomerExists(String username, String email) {
		if(checkUsernameExists(username) || checkEmailExists(email)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkUsernameExists(String username) {
		if(null != findByUsername(username)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkEmailExists(String email) {
		if(null != findByEmail(email)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Users login(String username, String password) {
		Users user =this.findByUsername(username);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public Users findByUserId(Long userId) {

		return userRepo.findByUserId(userId);
	}
}
