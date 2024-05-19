package com.masantello.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.demo.dto.BookRequestDTO;
import com.masantello.demo.dto.EmailRequestDTO;
import com.masantello.demo.exceptions.BookNotFoundException;
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

	@Autowired
	private EmailServiceClient emailServiceClient;

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

	public void registerBuyer(String bookId, String buyerEmail) {
		Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);

		if (this.isBookSoldOut(book)) {
			EmailRequestDTO emailRequest = new EmailRequestDTO(buyerEmail, Constants.FAILED_SUBJECT_EMAIL,
					"Que pena! O seu pedido do livro " + book.getTitle() + " não existe em estoque. :(");
			
			emailServiceClient.sendEmail(emailRequest);
		}

		Order order = new Order(book, buyerEmail);
		orderRepository.save(order);

		book.setQuantityInSupply((short) (book.getQuantityInSupply() - 1));

		EmailRequestDTO emailRequest = new EmailRequestDTO(buyerEmail, Constants.CONFIRMATION_SUBJECT_EMAIL,
				"O seu pedido do livro " + book.getTitle() + " foi confirmado! Em breve chegará em sua casa.");

		emailServiceClient.sendEmail(emailRequest);

	}
	
	private Book findById(String id) {
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
	
	public Book updateBook(String id, BookRequestDTO bookDto) {
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
	
	

}
