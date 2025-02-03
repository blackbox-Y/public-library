
package com.libshop.library.service.userSide;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.libshop.library.model.Book;
//import com.libshop.library.model.Book_status;

public interface BookService_interface {
	public Slice <Book> findAllBooks (int pageNumber);
	public Slice <Book> findByAuthor (int PageNumber, String author);
	public Slice <Book> findByGenre (int PageNumber, String genre);
	public Slice <Book> findByPrice (int PageNumber, int min, int max);
	
	public List<Book> findbyName (String name);
	
	public Optional<Book> findByID (Long ID);
}
