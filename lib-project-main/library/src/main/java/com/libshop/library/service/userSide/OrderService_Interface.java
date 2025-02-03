package com.libshop.library.service.userSide;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.libshop.library.DTO.Request.OrderSearchRequest;
import com.libshop.library.model.Order;
import com.libshop.library.model.User;

public interface OrderService_Interface {
	public Optional<Order> findById (Long ID);
	
	public Order createOrder (Order order);
	
	public Page <Order> findOrders (OrderSearchRequest request, int pageNumber);
	
	public Page <Order> findAll (int pageNumber);
	public Page <Order> findUsersOrders (int pageNumber, User user);
}
