package pl.javastart.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import pl.javastart.model.User;
import pl.javastart.util.ConnectionProvider;

public class MysqlUserDAO implements UserDAO {
	
	private final static String CREATE = "INSERT INTO user(pesel, firstname, lastname) VALUES(:pesel, :firstName, :lastName);";
	private final static String READ = "SELECT pesel, firstname, lastname FROM user WHERE pesel = :pesel;";
	private final static String UPDATE = "UPDATE user SET pesel=:pesel, firstname=:firstName, lastname=:lastName WHERE pesel = :pesel;";
	private final static String DELETE = "DELETE FROM user WHERE pesel=:pesel;";
	
	private NamedParameterJdbcTemplate template;
	
	public MysqlUserDAO() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
	}

	@Override
	public boolean create(User user) {
		BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(user);
		int rowsAffected = template.update(CREATE, beanParamSource);
		boolean result = false;
		if (rowsAffected > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public User read(String pesel) {
		User resultUser = null;
		SqlParameterSource namedParameters = new MapSqlParameterSource("pesel", pesel);
		List<User> userList = template.query(READ, namedParameters, BeanPropertyRowMapper.newInstance(User.class));
		if (userList.get(0) != null) {
			resultUser = userList.get(0);
		}
		return resultUser;
	}

	@Override
	public boolean update(User user) {
		BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(user);
		int rowsAffected = template.update(UPDATE, beanParamSource);
		boolean result = false;
		if (rowsAffected > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean delete(User user) {
		SqlParameterSource namedParameter = new MapSqlParameterSource("pesel", user.getPesel());
		int rowsAffected = template.update(DELETE, namedParameter);
		boolean result = false;
		if (rowsAffected > 0) {
			result = true;
		}
		return result;
	}
}