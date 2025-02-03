package com.libshop.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph;

import com.libshop.library.model.Book;
import com.libshop.library.model.Role;
import com.libshop.library.model.User;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserRepository extends JpaRepository<User, Long> {
	
	@EntityGraph(attributePaths = "roles")
	Page <User> findAll(Pageable pageable);
	
	@EntityGraph(attributePaths = "roles")
	User findByEmail(String email);
	
	@EntityGraph(attributePaths = "roles")
	Optional <User> findById(Long Id);
	
	@EntityGraph(attributePaths = "roles")
	Page <User> findByLocation(Pageable pageable, String city);
	
	@EntityGraph(attributePaths = "roles")
	@Query("SELECT book FROM book_table "
			+ "WHERE (coalesce(:name, null) IS NULL OR book.name IN name)"
			+ "AND (coalesce(:author, null) IS NULL OR book.author IN author)"
			+ "AND (coalesce(:genre, null) IS NULL OR book.genre IN genre)"
			+ "AND (coalesce(:priceMin, null) IS NULL OR book.price BETWEEN :priceMin AND :priceMax)"
			+ "ORDER BY price ASC")
	Page <Book> searchRequest (
			Long ID,
			String name,
			String surname,
			String email,
			String Country
			);
}
