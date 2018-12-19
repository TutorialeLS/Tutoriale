package com.library.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Book {
	private Long id;
	private Long book_name;
	private LocalDate date_published;
	private Long ISBN;
	private Long book_author_id;
	private Long library_id;
}
