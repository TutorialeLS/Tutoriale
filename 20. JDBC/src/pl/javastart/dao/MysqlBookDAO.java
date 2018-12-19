package pl.javastart.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import pl.javastart.model.Book;
import pl.javastart.util.ConnectionProvider;

public class MysqlBookDAO implements BookDAO {

	private final static String CREATE = "INSERT INTO book(isbn, title, description) VALUES(:isbn, :title, :description);";
	private final static String READ = "SELECT isbn, title, description FROM book WHERE isbn = :isbn;";
	private final static String UPDATE = "UPDATE book SET isbn=:isbn, title=:title, description=:description WHERE isbn = :isbn;";
	private final static String DELETE = "DELETE FROM book WHERE isbn=:isbn;";

	private NamedParameterJdbcTemplate template;

	public MysqlBookDAO() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
	}

	@Override
	public boolean create(Book book) {
		BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(book);
		int rowsAffected = template.update(CREATE, beanParamSource);
		boolean result = false;
		if (rowsAffected > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public Book read(String isbn) {
		Book resultBook = null;
		SqlParameterSource namedParameters = new MapSqlParameterSource("isbn", isbn);
		List<Book> bookList = template.query(READ, namedParameters, BeanPropertyRowMapper.newInstance(Book.class));
		if (bookList.get(0) != null) {
			resultBook = bookList.get(0);
		}
		return resultBook;
	}

	@Override
	public boolean update(Book book) {
		BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(book);
		int rowsAffected = template.update(UPDATE, beanParamSource);
		boolean result = false;
		if (rowsAffected > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean delete(Book book) {
		SqlParameterSource namedParameter = new MapSqlParameterSource("isbn", book.getIsbn());
		int rowsAffected = template.update(DELETE, namedParameter);
		boolean result = false;
		if (rowsAffected > 0) {
			result = true;
		}
		return result;
	}
}