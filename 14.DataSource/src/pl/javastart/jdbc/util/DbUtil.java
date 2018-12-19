package pl.javastart.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

    public static void insert(String name, String country, String district, int population) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection();
             Statement stmt = conn.createStatement();){
            String query = String
                    .format("INSERT INTO city(Name, CountryCode, District, Population) VALUES ('%s', '%s', '%s', %d)",
                            name, country, district, population);
            stmt.executeUpdate(query);
        }
    }

    public static void delete(String name) throws SQLException {
        String selectQuery = String.format("SELECT ID FROM city WHERE Name='%s'", name);
        try (Connection conn = ConnectionProvider.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(selectQuery);){
            if (resultSet.next()) {
                String deleteQuery = String.format("DELETE FROM city WHERE ID=%d", resultSet.getInt(1));
                stmt.executeUpdate(deleteQuery);
            }
        }
    }
}