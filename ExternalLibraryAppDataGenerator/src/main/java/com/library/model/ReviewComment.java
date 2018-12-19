package com.library.model;

import lombok.Data;

@Data
public class ReviewComment {
	private Long id;
	private String short_description;
	private String text;
	private Long review_id;
	private Long user_id;
}
