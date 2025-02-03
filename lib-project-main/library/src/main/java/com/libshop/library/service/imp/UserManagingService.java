package com.libshop.library.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.libshop.library.model.User;
import com.libshop.library.repository.UserRepository;
import com.libshop.library.security.UDSimp;
import com.libshop.library.security.UserDetailsImp;
import com.libshop.library.service.userSide.UserServiceManaging_interface;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserManagingService implements UserServiceManaging_interface{
	UserRepository repo;
	@Override
	public User createUser(User user) {
		repo.save(user);
		return user;
	}

	@Override
	public Optional <User> updateUser(Long ID, User user) {
		repo.findById(ID);
		repo.save(user);
		return repo.findById(ID);
	}
	
	@Override
	public Optional <User> showUser(Long Id) {
		return repo.findById(Id);
	}

	@Override
	public List<User> showAll() {
		return repo.findAll();
	}

}
