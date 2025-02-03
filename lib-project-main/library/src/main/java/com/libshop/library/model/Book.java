package com.libshop.library.model;

import java.util.Set;

import com.libshop.library.model.status.Book_status;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "book_table")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"Id"})
public class Book {
	@Id @Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "book_id_seq"))
	@SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", initialValue = 109, allocationSize = 1)
	private Long Id;
	
	
    @Column(name = "title", nullable = false)
    private String name;
    
    @Column(name = "author", nullable = false)
    private String author;
    
    @Column(name = "genre", nullable = false)
    private String genre;
   
    
    @Column(name = "price")
    private Integer price;
    
    @Column(name = "amount")
    private Integer amount;
    
    @ElementCollection(targetClass = Book_status.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Book_status> status;

    @Column(name = "description")
    private String description;
}
