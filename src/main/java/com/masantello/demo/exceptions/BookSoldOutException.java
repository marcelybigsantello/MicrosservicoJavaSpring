package com.masantello.demo.exceptions;

public class BookSoldOutException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookSoldOutException() {
		super("O estoque desse livro esgotou");
	}
	
	public BookSoldOutException(String message) {
		super(message);
	}
}
