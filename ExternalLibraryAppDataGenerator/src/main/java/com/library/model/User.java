package com.library.model;

import lombok.Data;

@Data
public class User {

	private Long id;
	private String first_name;
	private Boolean is_banned;
	private String last_name;
	private String password;
	private String username;
	private Long user_role_id;
	
}
