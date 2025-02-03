package com.libshop.library.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.libshop.library.model.Order;
import com.libshop.library.service.imp.OrderService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/v1/Book/Shop")
public class OrderController {
	OrderService service = null;
	
	
	@GetMapping("/findOrder")
	public Optional<Order> findByID (@RequestBody Long ID) {
		return service.findById(ID);
	}
}
