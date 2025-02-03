package com.libshop.library.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "userz")
@NoArgsConstructor
@AllArgsConstructor

public class User {
	
	// ------------------- ID,table allocation & name initialization 
	@Id @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq"))
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", initialValue = 4, allocationSize = 1)
    private Long Id;
	
	
	// ------------------- fields
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	
	@Column(name = "password", nullable = false)
	private String password;
	
	
	@Column(name = "Country")
	private String Country;
	
	@Column(name = "active")
    private boolean active;
	
	@Column(name = "activation_code")
	private String activationCode;
	
	@Column(name = "password_reset_code")
	private String passwordResetCode;

	
	
	// ------------------- creating a table of Roles
	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
	
	
	
	// ------------------- adding a list of books
	@ManyToMany
	private List<Book> bookList;
	
	@ManyToMany
	private List<Order> orderList;
}

