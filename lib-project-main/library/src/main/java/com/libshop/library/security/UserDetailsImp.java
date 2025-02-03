package com.libshop.library.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.libshop.library.model.User;

import lombok.Data;

@Data
public class UserDetailsImp implements UserDetails{
	
	private final Long Id;
	private final String password;
	private final String Email;
	private final boolean active;
	private final Collection<? extends GrantedAuthority> authorities;
	
	public static UserDetailsImp create (User user) {
		String userRole = user.getRoles().iterator().next().getAuthority();
		List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(userRole));
		return new UserDetailsImp(user.getId(), user.getPassword(), user.getEmail(), user.isActive(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		return Email;
	}

}
