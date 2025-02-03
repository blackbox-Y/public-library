package com.libshop.library.repository;


import java.util.Optional;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.libshop.library.model.Book;


public interface BookRepository extends JpaRepository <Book, Long> {
	Page <Book> findAll (Pageable pageable);
	Slice <Book> findByAuthor (Pageable pageable, String Author);
	Slice <Book> findByGenre (Pageable pageable, String genre);
	Slice <Book> findByPrice (Pageable pageable, int min, int max);
	
	
	Optional <Book> findById (Long Id);
	List <Book> findByName (String name);
	
	@Query("SELECT book FROM book_table "
			+ "WHERE (coalesce(:name, null) IS NULL OR book.name IN name)"
			+ "AND (coalesce(:author, null) IS NULL OR book.author IN author)"
			+ "AND (coalesce(:genre, null) IS NULL OR book.genre IN genre)"
			+ "AND (coalesce(:priceMin, null) IS NULL OR book.price BETWEEN :priceMin AND :priceMax)"
			+ "ORDER BY price ASC")
	Page <Book> searchRequest (
			String name,
			String author,
			String genre,
			
			Integer priceMin,
			Integer priceMax
			);
	
	void deleteById (Long id);
}
