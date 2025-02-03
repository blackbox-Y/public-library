package com.libshop.library.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.libshop.library.model.Book;
//import com.libshop.library.model.Book_status;
import com.libshop.library.repository.BookRepository;
import com.libshop.library.service.userSide.BookService_interface;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class BookService implements BookService_interface{
	private final BookRepository repo;
	
	@Override
	public Page <Book> findAllBooks (int PageNumber) {
		Pageable pageable = PageRequest.of(PageNumber, 10, Sort.by("name"));
		return repo.findAll(pageable);
	}
	
	@Override
	public List <Book> findbyName (String name) {
		return repo.findByName(name);
	}
	
	@Override
	public Slice <Book> findByAuthor (int PageNumber, String author) {
		Pageable pageable = PageRequest.of(PageNumber, 10);
		return repo.findByAuthor(pageable, author);
	}
	
	@Override
	public Slice <Book> findByGenre (int PageNumber, String genre) {
		Pageable pageable = PageRequest.of(PageNumber, 10);
		return repo.findByGenre(pageable, genre);
	}

	@Override
	public Optional <Book> findByID (Long ID) {
		return repo.findById(ID);
	}
	
	@Override
	public Slice<Book> findByPrice(int PageNumber, int min, int max) {
		Pageable pageable = PageRequest.of(PageNumber, 10);
		return repo.findByPrice(pageable, min, max);
	}
	
	
//	@Override
//	public String deleteBook (Long ID) {	
//		repo.deleteById(ID);
//		return "book is deleted";
//	}
//	
//	@Override
//	public String changeStatus(Long ID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	@Override
//	public Book addBook (Book book) {
//		System.out.println("addBook: " +book);
//		return repo.save(book);
//	}

	
//	public String changeStatus (Long ID, Set<Book_status> status) {
//		repo.findByID(ID).setStatus(status);	
//		return "status \"" +status.toString()+"\" is set";
//	}
		
//	public String showDescription (Long ID) {
//		return repo.findById(ID).getDescription();
//	}
	
//	public String changeDescription (Long ID) {
//		return repo.findByID(ID).getDescription();
//	}
	
//	private Long returnID (Book book) {
//		return repo.showID(book.getName(), book.getAuthor());
	
//	}
}