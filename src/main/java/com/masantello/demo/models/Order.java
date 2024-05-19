package com.masantello.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="Order")
@Table(name="Order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Book book;
	private String buyerEmail;
	
	public Order(Book book, String buyerEmail) {
		super();
		this.book = book;
		this.buyerEmail = buyerEmail;
	}

	public Order(Integer id, Book book, String buyerEmail) {
		super();
		this.id = id;
		this.book = book;
		this.buyerEmail = buyerEmail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
		
}
