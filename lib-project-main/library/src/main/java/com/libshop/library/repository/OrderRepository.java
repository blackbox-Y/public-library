package com.libshop.library.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.libshop.library.model.Order;
import com.libshop.library.model.User;


public interface OrderRepository extends JpaRepository<Order, Long> {
	Page <Order> findAll (Pageable pageable);
	Page <Order> findUsersOrders (Pageable pageable, User user);
	
	@Query("SELECT order FROM Orders "
			+ "WHERE (coalesce(:Id, null) IS NULL OR order.Id IN Id)"
			+ "AND (coalesce(:name, null) IS NULL OR order.name IN name)"
			+ "AND (coalesce(:surname, null) IS NULL OR order.surname IN surname)"
			+ "AND (coalesce(:email, null) IS NULL OR order.email IN email)"
			+ "AND (coalesce(:date, null) IS NULL OR order.date IN date)"
			+ "AND (coalesce(:priceMin, null) IS NULL OR order.totalPrice BETWEEN :priceMin AND :priceMax)"
			+ "AND (coalesce(:user, null) IS NULL OR order.user IN user)"
			+ "ORDER BY price ASC")
	Page <Order> adminOrderSearchRequest (
			Long Id,
			User user,
			
			String name,
			String surname,
			String email,
			
			LocalDateTime date,
			
			Integer priceMin,
			Integer priceMax,
			Pageable pageable
			);
	
	@Query("SELECT order FROM Orders "
			+ "WHERE (coalesce(:Id, null) IS NULL OR order.Id IN Id)"
			+ "AND (coalesce(:email, null) IS NULL OR order.email IN email)"
			+ "AND (coalesce(:priceMin, null) IS NULL OR order.totalPrice BETWEEN :priceMin AND :priceMax)"
			+ "AND (coalesce(:date, null) IS NULL OR order.date IN date)"
			+ "AND (coalesce(:user, null) IS NULL OR order.user IN user)"
			+ "ORDER BY price ASC")
	Page <Order> searchRequest (
			Long Id,
			String email,
			
			Integer priceMin,
			Integer priceMax, 
			
			LocalDateTime date,
			User user,
			Pageable pageable
			);
	
	Optional <Order> findById (Long Id);
	Page <Order> findByUser (Pageable pageable, User user);
}
