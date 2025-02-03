package com.libshop.library.DTO.Request;

import java.time.LocalDateTime;

import com.libshop.library.model.User;

import lombok.Data;

@Data
public class OrderSearchRequest {
	private Long Id;
	private String email;
	
	private Integer priceMin;
	private Integer priceMax;
	
	private LocalDateTime date;
	private User user;

}
