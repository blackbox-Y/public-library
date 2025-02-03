package com.libshop.library.service.imp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.libshop.library.DTO.Request.Book_SearchRequest;
import com.libshop.library.model.Book;
import com.libshop.library.model.Order;
import com.libshop.library.model.User;
import com.libshop.library.repository.BookRepository;
import com.libshop.library.repository.OrderRepository;
import com.libshop.library.repository.UserRepository;
import com.libshop.library.service.userSide.AdminService_Interface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService implements AdminService_Interface {
	private final UserRepository userRepo;
	private final BookRepository bookRepo;
	private final OrderRepository orderRepo;
	
	@Override
	public Page<User> findAllUsers(int PageNumber) {
		Pageable pageable = PageRequest.of(PageNumber, 10, Sort.by("ID"));
		return userRepo.findAll(pageable);
	}

	@Override
	public Page<Book> findAllBooks(int PageNumber) {
		Pageable pageable = PageRequest.of(PageNumber, 10, Sort.by("ID"));
		return bookRepo.findAll(pageable);
	}

	@Override
	public Page<Order> findAllUserOrders(int PageNumber, Long UserID) {
		Pageable pageable = PageRequest.of(PageNumber, 10, Sort.by("ID"));
		return orderRepo.findAll(pageable);
	}

	@Override
	public Order findOrderByID(Long ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByID(Long ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookByID(Long ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Book> findBookByProperies(Book_SearchRequest SearchRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book editBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Order> findorderByProperies(Book_SearchRequest SearchRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
