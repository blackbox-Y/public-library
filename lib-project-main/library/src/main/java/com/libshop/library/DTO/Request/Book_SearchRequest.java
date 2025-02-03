package com.libshop.library.DTO.Request;
import lombok.Data;

@Data
public class Book_SearchRequest {
	private String name;
	private String author;
	private String genre;
	
	private Integer priceMin;
	private Integer priceMax;
	private Integer amount;
	
	private String description;
}
