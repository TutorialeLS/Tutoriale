package pl.javastart.weekop.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

	private static DataSource dataSource;

	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();//to nie rekurencja! 
		//Attempts to establish a connection with the data source that this DataSource object represents.
	}

	public static DataSource getDataSource() {
		if (dataSource == null) {//wzorzec Singleton
			try {
				Context initialContext = new InitialContext();
				Context envContext = (Context) initialContext
						.lookup("java:comp/env");
				DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
				dataSource = ds;
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		return dataSource;
	}
}