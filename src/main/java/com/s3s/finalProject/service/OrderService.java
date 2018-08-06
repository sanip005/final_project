package com.s3s.finalProject.service;

import java.util.List;

import com.s3s.finalProject.entity.Orders;

public interface OrderService {

	
	void save(Orders order);
	
	List<Orders> findAll();
	
	
}
