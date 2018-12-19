package pl.javastart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.javastart.model.User;
import pl.javastart.util.ConnectionProvider;
import pl.javastart.util.DbOperationException;

public class MySqlUserDao implements UserDao{
	private static final String CREATE="INSERT into user(pesel, firstname, lastname) VALUES(?,?,?);";
	private static final String READ="SELECT pesel, firstname,lastname FROM user WHERE pesel=?;";
	private static final String UPDATE="UPDATE user SET pesel=?, firstname=?, lastname=? WHERE pesel=?;";
	private static final String DELETE="DELETE FROM User WHERE pesel=?;";
	
	@Override
	public void create(User user) {
		try (Connection conn =  ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(CREATE);) {
			pstmt.setString(1, user.getPesel());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DbOperationException(e);
		}
		
	}
	@Override
	public User read(String pesel) {
		User user=null;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(READ);) {
			pstmt.setString(1, pesel);
			ResultSet resultSet=pstmt.executeQuery();
			if(resultSet.next()) {
				user=new User();
				user.setPesel(resultSet.getString("pesel"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
			}
		}catch (SQLException e) {
			throw new DbOperationException(e);
		}
			return user;
	}
	@Override
	public void update(User user) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {
			pstmt.setString(1, user.getPesel());
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getPesel());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			throw new DbOperationException(e);
		}
	}
	@Override
	public void delete(User user) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setString(1, user.getPesel());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			throw new DbOperationException(e);
		}
	}
}
