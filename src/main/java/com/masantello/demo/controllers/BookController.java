package com.masantello.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masantello.demo.dto.BookRequestDTO;
import com.masantello.demo.dto.OrderRequestDTO;
import com.masantello.demo.models.Book;
import com.masantello.demo.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	/*@GetMapping
	public List<Book> getUpcomingBooks(){
		return bookService.getUpcomingBooks();
	}*/
	
	@PostMapping()
	public Book createBook(@RequestBody BookRequestDTO bookDto) {
		return bookService.createBook(bookDto);
	}
	
	@PostMapping(value = "/{bookId}/createOrder")
	public void registerNewOrder(@PathVariable String bookId, @RequestBody OrderRequestDTO orderRequest) {
		bookService.registerBuyer(bookId, orderRequest.getBuyerEmail());
	}
		
	@PutMapping(value = "/{id}")
	public Book updateBook(@PathVariable String id, @RequestBody BookRequestDTO bookDto) {
		return bookService.updateBook(id, bookDto);
	}
		
}
