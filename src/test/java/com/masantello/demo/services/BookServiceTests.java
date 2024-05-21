package com.masantello.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.masantello.demo.models.Book;
import com.masantello.demo.models.enums.Language;
import com.masantello.demo.repositories.BookRepository;
import com.masantello.demo.repositories.OrderRepository;

class BookServiceTests {

	@Mock
	private BookRepository bookRepository;
	
	@Mock
	private OrderRepository orderRepository;

	@InjectMocks
	private BookService bookService;

	@Test
	public void shouldReturnAllBooks() {
		// Given
		List<Book> books = new ArrayList<Book>();

		// When
		books = bookService.getAllBooks();

		// Then
		assertNotNull(books);
		assertEquals(books, loadBooks());
	}

	@Test
	public void shouldReturnAllUpcomingBooks() {
		// Given
		List<Book> books = new ArrayList<Book>();

		// When
		books = bookService.getUpcomingBooks();
		
		//Then
		assertThat(books).isNotEmpty();
		assertEquals(books, loadUpcomingBooks());
		assertEquals(4, books.size());
		assertThat(loadUpcomingBooks().size()).isEqualTo(books.size());
	}


	private List<Book> loadBooks() {
		List<Book> books = new ArrayList<Book>();

		Book book1 = new Book(1, "1984", "Clássico", "George Orwell", "Companhia das Letras", Language.PORTUGUESE, 460,
				LocalDate.parse("2009-05-01"), (short) 10);
		Book book2 = new Book(2, "A revolução dos Bichos", "", "George Orwell", "Companhia das Letras",
				Language.PORTUGUESE, 120, LocalDate.parse("2007-10-01"), (short) 10);
		Book book3 = new Book(3, "A planta de ferro", "Ambientado em Londres, em 1930, tem como tema "
				+ "a ambição romântica de Gordon Comstock de desafiar a adoração do deus do dinheiro e do status.",
				"George Orwell", "Principis", Language.PORTUGUESE, 256, LocalDate.parse("2021-01-10"), (short) 10);

		books.add(book1);
		books.add(book2);
		books.add(book3);

		return books;
	}

	private List<Book> loadUpcomingBooks() {
		List<Book> books = new ArrayList<Book>();
		
		Book book1 = new Book(1, "Um Porto Seguro", "Drama e Romance", "Nicholas Sparks", "Editora Arqueiro", 
				Language.PORTUGUESE, 304, LocalDate.now().plusMonths(2), (short) 10);
		Book book2 = new Book(2, "Um Amor para Recordar", "", "Nicholas Sparks", "Editora Arqueiro",
				Language.PORTUGUESE, 144, LocalDate.now().plusYears(1), (short) 20);
		Book book3 = new Book(3, "Diário de uma Paixão", "", "Nicholas Sparks", "Editora Arqueiro", 
				Language.PORTUGUESE, 256, LocalDate.now().plusMonths(3), (short) 30);
		Book book4 = new Book(4, "A Escolha", "", "Nicholas Sparks", "Editora Arqueiro",
				Language.PORTUGUESE, 240, LocalDate.now().plusDays(20), (short) 15);
		Book book5 = new Book(5, "Dear John", "", "Nicholas Sparks", "Editora Arqueiro", 
				Language.ENGLISH, 256, LocalDate.parse("2017-04-30"), (short) 20);
				
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		
		return books;
	}
}
