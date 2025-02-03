package com.libshop.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libshop.library.model.User;
import com.libshop.library.service.imp.BookService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/v1/Book/User")
public class UserController {
	UserService service = null;
	
	@PostMapping("/reg")
	public User createUser (@RequestBody User user) {
		return service.createUser(user);
	}
	
	@PutMapping("/update/{ID}")
	public Optional <User> update (@PathVariable Long ID, @RequestBody User user) {
		return service.updateUser(ID, user);
	}
	
	@GetMapping("/show/{ID}") 
	public Optional <User> show (@PathVariable Long ID) {
		return service.showUser(ID);
	}
	
	@GetMapping("/showAll") 
	public List<User> showAll () {
		return service.showAll();
	}
}
