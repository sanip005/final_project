package com.s3s.finalProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.s3s.finalProject.entity.Orders;

public interface OrderRepo extends CrudRepository <Orders, Long>{

	List<Orders> findAll();
	
	//List<Orders> findByUserId(Long userId);

	
}
