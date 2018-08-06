package com.s3s.finalProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.s3s.finalProject.entity.Users;

public interface UserRepo extends CrudRepository <Users, Long>{

	Users findByEmail(String email);
	
	Users findByUsername(String username);
	
	Users findByUserId(Long userId);
	
}
