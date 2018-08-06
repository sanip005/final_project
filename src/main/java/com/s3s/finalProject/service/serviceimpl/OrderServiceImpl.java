package com.s3s.finalProject.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s3s.finalProject.entity.Orders;
import com.s3s.finalProject.repository.OrderRepo;
import com.s3s.finalProject.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private OrderRepo orderRepo;

	
	
	public void save(Orders order) {
		orderRepo.save(order);
	}


	@Override
	public List<Orders> findAll() {
		return orderRepo.findAll();
	}


	
	
//	@Override
//	public List<Orders> findAll() {
//		return orderRepo.findAll();
//	}
//
//	@Override
//	public List<Orders> findByUserId(Long userId) {
//		
//		return orderView.;
//	}


//	@Override
//	public List<Orders> findByUserId(Long userId) {
//		return orderRepo.findByUserId(userId);
//	}
	
	

	
	
}
