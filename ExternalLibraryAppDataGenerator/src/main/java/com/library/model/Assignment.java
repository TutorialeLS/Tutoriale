package com.library.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Assignment {
	private Long id;
	private LocalDate start;
	private LocalDate end;
	private LocalDate due_time;
	private Long book_id;
	private Long user_id;
}
