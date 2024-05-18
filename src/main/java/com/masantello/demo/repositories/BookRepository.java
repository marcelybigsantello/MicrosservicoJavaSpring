package com.masantello.demo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masantello.demo.models.Book;

import jakarta.annotation.Nonnull;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{
	
	@Nonnull
	public Optional<Book> findById(@Nonnull String id);
	
	@Query(value = "SELECT * from Book b WHERE PARSE(b.releaseDate AS TIMESTAMP) >= :currentDate", nativeQuery = true)
	public List<Book> findBooksReleased(@Param("currentDate") LocalDate currentDate);
	
}
