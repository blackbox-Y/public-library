package com.libshop.library.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Orders")
public class Order {
		// ------------------- ID,table allocation & name initialization 
		@Id @Column(name = "Id")
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq"))
	    @SequenceGenerator(name = "order_id_seq", sequenceName = "order_id_seq", initialValue = 6, allocationSize = 1)
	    private Long Id;
		
		// --------------- fields
		@Column(name = "total_price", nullable = false)
	    private Double totalPrice;
		
		@Column(name = "date", columnDefinition = "timestamp default current_timestamp")
	    private LocalDateTime date = LocalDateTime.now();
		
		@Column(name = "name", nullable = false)
		private String name;
		
		@Column(name = "surname", nullable = false)
		private String surname;
		
		@Column(name = "email", nullable = false)
		private String email;
		
		
		// --------------- related lists
		@ElementCollection(targetClass = Order_status.class, fetch = FetchType.EAGER)
		@CollectionTable(name = "order_status", joinColumns = @JoinColumn(name = "order_id"))
		@Enumerated(EnumType.STRING)
	    	private Set<Order_status> status;
		
		@ManyToMany
		private List<Book> books = new ArrayList<>();
		
		@ManyToOne
		private User user;
}
