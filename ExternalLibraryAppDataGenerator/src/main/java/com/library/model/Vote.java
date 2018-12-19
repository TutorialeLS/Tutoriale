package com.library.model;

import lombok.Data;

@Data
public class Vote {
	private Long id;
	private Integer vote_down;
	private Integer vote_up;
	private Long article_id;
	private Long article_comment_id;
	private Long book_id;
	private Long book_comment_id;
	private Long review_id;
	private Long review_comment_id;
	private Long user_id;
}
