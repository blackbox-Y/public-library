package com.libshop.library.service.userSide;

import com.libshop.library.model.User;

import java.util.List;
import java.util.Optional;

import com.libshop.library.model.Book;
import com.libshop.library.model.Order;

public interface UserServiceManaging_interface {
	public User createUser (User user);
	
	public Optional <User> updateUser (Long ID, User user);
	
	public Optional <User> showUser (Long Id);
	
	public List<User> showAll ();
	
//	public List<Book> showUsersBooks (Long id);
//	
//	public List<Order> showUsersOrders (Long id);
}
