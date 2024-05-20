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
import com.masantello.demo.models.Order;
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
	
	@GetMapping(value = "/orders")
	public List<Order> getAllOrders(){
		return bookService.getAllOrders();
	}
	
	@PostMapping()
	public Book createBook(@RequestBody BookRequestDTO bookDto) {
		return bookService.createBook(bookDto);
	}
	
	@PostMapping(value = "/{bookId}/registerOrder")
	public void registerNewOrder(@PathVariable Integer bookId, @RequestBody OrderRequestDTO orderRequest) {
		bookService.registerBuyerInOrder(bookId, orderRequest.getBuyerEmail());
	}
		
	@PutMapping(value = "/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody BookRequestDTO bookDto) {
		return bookService.updateBook(id, bookDto);
	}
		
}
