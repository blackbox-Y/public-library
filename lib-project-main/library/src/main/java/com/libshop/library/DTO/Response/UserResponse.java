package com.libshop.library.DTO.Response;

import org.springframework.data.domain.Page;

import com.libshop.library.model.Order;
import com.libshop.library.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class UserResponse {
	private User user;
	private Page <Order> order;
}
