package com.library.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRole {
	private Long id;
	private LocalDate date_created;
	private LocalDate date_Deleted;
	private String user_role_name;
}
