package pl.javastart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		final String driver = "com.mysql.cj.jdbc.Driver";// adres do sterownika bazy danych
		Class.forName(driver); // zaladowanie klasy
		final String dbPath = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
		Connection conn = DriverManager.getConnection(dbPath, "root", "admin");

		Statement statement = conn.createStatement();
		final String sqlQuery = "SELECT Name, Population FROM city";
		ResultSet resultSet = statement.executeQuery(sqlQuery);// obiekt result set zawiera wyniki zapytania sql
		// executeQuery(String sqlQuery) - metoda, która zwraca w wyniku zbiór wyników
		// otrzymanych w odpowiedzi z bazy w postaci obiektu ResultSet.
		// wiêc u¿yteczna w przypadku zapytañ typu SELECT.
		// executeUpdate(String sqlQuery) - metoda przeznaczona
		// do wykonywania zapytañ aktualizacji danych
		// - INSERT, UPDATE, DELETE.
		String cityName = null;
		int cityPopulation = 0;
		while (resultSet.next()) {
			cityName = resultSet.getString("Name");
			cityPopulation = resultSet.getInt("Population");
			System.out.println(cityName + " " + cityPopulation);
		}

		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
		if (conn != null) {
			conn.close();
		}

	}
}
