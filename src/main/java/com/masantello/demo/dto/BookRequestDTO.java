package com.masantello.demo.dto;

import java.time.LocalDate;

import com.masantello.demo.models.enums.Language;

public class BookRequestDTO {

	private String title;
	private String description;
	private String author;
	private String editor;
	private Language language;
	private int numberOfPages;
	private LocalDate releaseDate;
	private short quantityInSupply;

	public BookRequestDTO(String title, String description, String author, String editor, Language language,
			int numberOfPages, LocalDate releaseDate, short quantityInSupply) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.editor = editor;
		this.language = language;
		this.numberOfPages = numberOfPages;
		this.releaseDate = releaseDate;
		this.quantityInSupply = quantityInSupply;
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

	public short getQuantityInSupply() {
		return quantityInSupply;
	}

	public void setQuantityInSupply(short quantityInSupply) {
		this.quantityInSupply = quantityInSupply;
	}
	
}
