package com.library.model;

import lombok.Data;

@Data
public class Article {
	private Long id;
	private String title;
	private String short_description;
	private String text;
	private Long user_id;
}
