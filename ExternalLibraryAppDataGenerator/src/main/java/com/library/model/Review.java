package com.library.model;

import lombok.Data;

@Data
public class Review {
	private Long id;
	private String short_description;
	private String text;
	private Long book_id;
	private Long user_id;
}
