package com.masantello.demo.exceptions;

public class DataIntegrityViolationsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationsException() {
		super("O título desse livro já existe!");
	}
	
	public DataIntegrityViolationsException(String message) {
		super(message);
	}
}
