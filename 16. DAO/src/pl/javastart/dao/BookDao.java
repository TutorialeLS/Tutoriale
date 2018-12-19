package pl.javastart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.javastart.model.Book;
import pl.javastart.util.ConnectionProvider;

public class BookDao {
	private final static String CREATE = "INSERT INTO book(isbn, title, description) VALUES(?, ?, ?);";
	private final static String READ = "SELECT isbn, title, description FROM book WHERE isbn = ?;";
	private final static String UPDATE = "UPDATE book SET isbn=?, title=?, description=? WHERE isbn = ?;";
	private final static String DELETE = "DELETE FROM book WHERE isbn=?;";

	public void create(Book book) throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(CREATE)) {
			stmt.setString(1, book.getIsbn());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getDescription());
			stmt.executeUpdate();// ???
		}
	}

	public Book read(String isbn) throws SQLException {
		Book book = null;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(READ)) {
			stmt.setString(1, isbn);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				book = new Book();
				book.setIsbn(resultSet.getString("isbn"));
				book.setDescription(resultSet.getString("description"));
				book.setTitle(resultSet.getString("title"));
			}
		}
		return book;

	}

	public void update(Book book) throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, book.getIsbn());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getDescription());
			stmt.setString(4, book.getIsbn());
			stmt.executeUpdate();
		}
	}

	public void delete(Book book) throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setString(1, book.getIsbn());
			stmt.executeUpdate();
		}
	}
}
