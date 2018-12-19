package pl.javastart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.javastart.model.Book;
import pl.javastart.util.ConnectionProvider;
import pl.javastart.util.DbOperationException;

public class MysqlBookDao implements BookDao {
	private static final String READ = "SELECT isbn, title, description FROM book WHERE isbn = ?;";
	private static final String CREATE = "INSERT into book(isbn, title, description) VALUES(?,?,?);";
	private static final String UPDATE= "UPDATE book SET isbn=?, title=?, description=? WHERE isbn=?;";
	private static final String DELETE="DELETE FROM book WHERE isbn=?;";
	@Override
	public void create(Book book) {
		try (Connection conn =  ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(CREATE);) {
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DbOperationException(e);
		}

	}

	@Override
	public Book read(String isbn) {
		Book book=null;
		try (Connection conn =  ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(READ);) {
			pstmt.setString(1, isbn);
			ResultSet resultSet=pstmt.executeQuery();
			if(resultSet.next()) {
				book=new Book();
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setDescription(resultSet.getString("description"));
			}
		} catch (SQLException e) {
			throw new DbOperationException(e);
		}
		return book;
	}

	@Override
	public void update(Book book) {
		try (Connection conn =  ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getDescription());
			pstmt.setString(4, book.getIsbn());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DbOperationException(e);
		}

	}

	@Override
	public void delete(Book book) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setString(1, book.getIsbn());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DbOperationException(e);
		}

	}

}
