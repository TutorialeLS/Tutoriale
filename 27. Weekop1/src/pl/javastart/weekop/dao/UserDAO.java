package pl.javastart.weekop.dao;

import java.util.List;

import pl.javastart.model.User;


public interface UserDAO extends GenericDAO<User, Long> {

	List<User> getAll();
	User getUserByUsername(String username);
	
}