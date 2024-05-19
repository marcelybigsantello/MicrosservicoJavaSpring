package com.masantello.demo.dto;

import com.masantello.demo.models.Book;

public class OrderRequestDTO {

	private Book book;
	private String buyerEmail;
	
	public OrderRequestDTO(Book book, String buyerEmail) {
		this.book = book;
		this.buyerEmail = buyerEmail;
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
