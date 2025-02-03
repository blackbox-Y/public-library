package com.libshop.library.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libshop.library.model.Book;
import com.libshop.library.service.imp.BookService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/Book")
public class BookController {
	private final BookService service;
	
	@GetMapping("/show")
	public Page <Book> showAll (int pageNumber){
		return service.findAllBooks(pageNumber);
	}
	
	@GetMapping("/hello")
	public String hello () {
		return "welcome to the library";
	}
	
	@GetMapping("/show/Author:{author}/{page}")
	public Slice <Book> authorBooks (@PathVariable String author, @PathVariable int page) {
		return service.findByAuthor(page, author);
	}
	
	@GetMapping("/show/Genre:{genre}/{page}")
	public Slice <Book> genreBooks (@PathVariable String genre, @PathVariable int page) {
		return service.findByGenre(page, genre);
	}
	
	@GetMapping("/{ID}")
	public Optional <Book>showBooks (@PathVariable Long ID) {
		return service.findByID(ID);
	}
	
	@GetMapping("/show/search/{page}")
	public Slice <Book> priceBook (@PathVariable int page, @RequestBody int min, @RequestBody int max) {
		return service.findByPrice(page, min, max);
	}

}
