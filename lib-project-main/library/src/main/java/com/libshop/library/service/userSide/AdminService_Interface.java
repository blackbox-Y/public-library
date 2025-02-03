package com.libshop.library.service.userSide;
import org.springframework.data.domain.Page;

import com.libshop.library.DTO.Request.Book_SearchRequest;
import com.libshop.library.model.*;


public interface AdminService_Interface {
	Page <User> findAllUsers (int PageNumber);
	Page <Book> findAllBooks (int PageNumber);
	Page <Order> findAllUserOrders (int PageNumber, Long UserID);
	
	Order findOrderByID (Long ID);
	User findUserByID (Long ID);
	Book findBookByID (Long ID);
	
	Page <Book> findBookByProperies(Book_SearchRequest SearchRequest);
	Page <Order> findorderByProperies(Book_SearchRequest SearchRequest);
	
	
	Book addBook (Book book);
	Book editBook (Book book);
	
	
}
