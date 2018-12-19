package com.library.model;

import lombok.Data;

@Data
public class ArticleComment {
	private Long id;
	private String short_description;
	private String text;
	private Long article_id;
	private Long user_id;
}
