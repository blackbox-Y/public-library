package com.libshop.library.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;


import com.libshop.library.security.UDSimp;
import com.libshop.library.service.imp.UserManagingService;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final UserManagingService service;
	private final UDSimp UDS;
	private final PasswordEncoder passwordEncoder;

	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/",
                "/registration/**",
                "/user/contacts",
                "/img/**",
                "/static/**",
                "/auth/**",
                "/menu/**",
                "/perfume/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and().formLogin()
		.defaultSuccessUrl("/user/account")
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and().csrf
        ().disable();
	}
	
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(UDS)
        .passwordEncoder(passwordEncoder);
}
}
