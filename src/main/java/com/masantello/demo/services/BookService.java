package com.masantello.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.demo.dto.BookRequestDTO;
import com.masantello.demo.exceptions.BookNotFoundException;
import com.masantello.demo.exceptions.BookSoldOutException;
import com.masantello.demo.exceptions.DataIntegrityViolationsException;
import com.masantello.demo.helper.Constants;
import com.masantello.demo.models.Book;
import com.masantello.demo.models.Order;
import com.masantello.demo.repositories.BookRepository;
import com.masantello.demo.repositories.OrderRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private OrderRepository orderRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book createBook(BookRequestDTO bookDto) {
		Book book = new Book(bookDto);
		return bookRepository.save(book);
	}
	
	public List<Book> getUpcomingBooks(){
		return bookRepository.findBooksReleased(LocalDate.now());
	}
	
	public Boolean isBookSoldOut(Book book) {
		return book.getQuantityInSupply() <= 0;
	}

	public void registerBuyerInOrder(Integer bookId, String buyerEmail) {
		Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);

		if (this.isBookSoldOut(book)) {
			throw new BookSoldOutException(Constants.ERROR_BOOK_IS_SOLD_OUT);
		}

		Order order = new Order(book, buyerEmail);
		orderRepository.save(order);

		book.setQuantityInSupply((short) (book.getQuantityInSupply()-1));
		bookRepository.save(book);
	}
	
	private Book findById(Integer id) {
		Optional<Book> book = bookRepository.findById(id);
		
		if (!book.isPresent()) {
			throw new BookNotFoundException(Constants.ERROR_BOOK_NOT_FOUND);
		}
		
		return book.get();
	}
	
	private Book findByTitle(BookRequestDTO novo) {
		Book book = bookRepository.findByTitle(novo.getTitle());
		if (book != null) {
			return book;
		}
		return null;
	}
	
	public Book updateBook(Integer id, BookRequestDTO bookDto) {
		Book book = findById(id);
		
		if (this.findByTitle(bookDto) != null && this.findByTitle(bookDto).getId() != id) {
			throw new DataIntegrityViolationsException(Constants.ERROR_BOOK_ALREADY_EXISTS);
		}
		
		book.setTitle(bookDto.getTitle());
		book.setDescription(bookDto.getDescription());
		book.setAuthor(bookDto.getAuthor());
		book.setEditor(bookDto.getEditor());
		book.setLanguage(bookDto.getLanguage());
		book.setNumberOfPages(bookDto.getNumberOfPages());
		book.setReleaseDate(bookDto.getReleaseDate());
		book.setQuantityInSupply(bookDto.getQuantityInSupply());
		
		return bookRepository.save(book);
	}
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}

}
