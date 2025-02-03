package com.libshop.library.security;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.libshop.library.model.User;
import com.libshop.library.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service("UserDetailsServiceImplementation")
@RequiredArgsConstructor
public class UDSimp implements UserDetailsService{
    private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null)  {
			throw new UsernameNotFoundException("user not found");
		} if (user.getActivationCode()!= null) {
			throw new LockedException("Email not activated");
		} return UserDetailsImp.create(user);
	}

}
