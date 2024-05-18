package com.masantello.demo.models;

import java.time.LocalDate;

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

@Entity(name="Books")
@Table(name="Books")
@Getter
@Setter	
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Books {

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
	private short numberInSupply;
	
	public Books(String id, String title, String description, String author, String editor, Language language,
			int numberOfPages, LocalDate releaseDate, short numberInSupply) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.editor = editor;
		this.language = language;
		this.numberOfPages = numberOfPages;
		this.releaseDate = releaseDate;
		this.numberInSupply = numberInSupply;
	}
	
}
