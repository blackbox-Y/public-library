package com.libshop.library.DTO.Request;

import lombok.Data;

@Data 
public class UserSearchRequest {
	private Long ID;
	private String name;
	private String surname;
	private String email;
	private String Country;	
}
