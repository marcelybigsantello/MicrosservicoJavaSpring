package com.masantello.demo.models;

import java.time.LocalDate;

import com.masantello.demo.dto.BookRequestDTO;
import com.masantello.demo.models.enums.Language;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Book")
@Table(name="Book")
@Getter
@Setter	
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String title;
	private String description;
	private String author;
	private String editor;
	private Language language;
	private int numberOfPages;
	private LocalDate releaseDate;
	private short qtdInSupply;
	
	public Book(String id, String title, String description, String author, String editor, Language language,
			int numberOfPages, LocalDate releaseDate, short qtdInSupply) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.editor = editor;
		this.language = language;
		this.numberOfPages = numberOfPages;
		this.releaseDate = releaseDate;
		this.qtdInSupply = qtdInSupply;
	}

	public Book(BookRequestDTO bookDto) {
		this.title = bookDto.getTitle();
		this.description = bookDto.getDescription();
		this.author = bookDto.getAuthor();
		this.editor = bookDto.getEditor();
		this.language = bookDto.getLanguage();
		this.numberOfPages = bookDto.getNumberOfPages();
		this.releaseDate = bookDto.getReleaseDate();
		this.qtdInSupply = bookDto.getQtdInSupply();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public short getQtdInSupply() {
		return qtdInSupply;
	}

	public void setQtdInSupply(short qtdInSupply) {
		this.qtdInSupply = qtdInSupply;
	}

}