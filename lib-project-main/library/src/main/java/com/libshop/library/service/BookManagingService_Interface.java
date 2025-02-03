package com.libshop.library.service;

import com.libshop.library.model.Book;
import com.libshop.library.service.userSide.BookService_interface;

public interface BookManagingService_Interface extends BookService_interface{
	public String changeStatus (Long ID);
	public String deleteBook (Long ID);
	public Book addBook (Book book);
}
