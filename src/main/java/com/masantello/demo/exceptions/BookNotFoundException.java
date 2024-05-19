package com.masantello.demo.exceptions;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		super("Livro não encontrado!");
	}
	
	public BookNotFoundException(String message) {
		super(message);
	}
}
