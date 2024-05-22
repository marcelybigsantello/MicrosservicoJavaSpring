package com.masantello.demo.exceptions;

public class RegisterBookException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RegisterBookException() {
		super("Erro ao efetuar cadastro de livro.");
	}
	
	public RegisterBookException(String message) {
		super(message);
	}
}
