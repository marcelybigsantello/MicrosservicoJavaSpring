package com.masantello.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.demo.dto.BookRequestDTO;
import com.masantello.demo.models.Book;
import com.masantello.demo.repositories.BookRepository;
import com.masantello.demo.repositories.OrderRepository;
import com.masantello.demo.services.EmailServiceClient;

@Service
public class BooksService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired
	private EmailServiceClient emailService;
	

	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book createBook(BookRequestDTO bookDto) {
		Book book = new Book(bookDto);
		return bookRepository.save(book);
	}
	
	
	
}
