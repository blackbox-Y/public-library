package com.libshop.library.service.imp;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.libshop.library.DTO.Request.OrderSearchRequest;
import com.libshop.library.model.Order;
import com.libshop.library.model.User;
import com.libshop.library.repository.OrderRepository;
import com.libshop.library.service.userSide.OrderService_Interface;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderService implements OrderService_Interface{
	OrderRepository repo;

	@Override
	public Optional<Order> findById (Long ID) {
		return 	repo.findById(ID);
	}

	@Override
	public Order createOrder(Order order) {
		repo.save(order);
		return order;
	}

	@Override
	public Page<Order> findOrders(OrderSearchRequest request, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("Date"));
		return repo.searchRequest(
				request.getId(), 
				request.getEmail(), 
				request.getPriceMin(), 
				request.getPriceMax(), 
				request.getDate(),
				request.getUser(),
				pageable);
	}

	@Override
	public Page<Order> findAll(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("Date"));
		return repo.findAll(pageable);
	}
	
	@Override
	public Page<Order> findUsersOrders(int pageNumber, User user) {
		Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("Date"));
		return repo.findByUser(pageable, user);
	}
}
