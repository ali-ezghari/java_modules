package main.java.fr.school42.chat.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Program {

	// Database connection credentials
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/chat_db";
	private static final String DB_USER = "aezghari";
	private static final String DB_PASSWORD = "secretpassword";

	public static void main(String[] args) {
		// 1. DriverManager uses the PostgreSQL JAR downloaded by Maven to establish a
		// connection
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

			System.out.println("Successfully connected to PostgreSQL!");

			// 2. Create an SQL Statement runner
			try (Statement statement = connection.createStatement()) {

				// 3. Execute a query against the 'users' table created by schema.sql & data.sql
				String query = "SELECT user_id, login, password FROM chat.users WHERE user_id = 1;";
				ResultSet resultSet = statement.executeQuery(query);

				// 4. Map the relational database row into your Java User model
				if (resultSet.next()) {
					Long id = resultSet.getLong("user_id");
					String login = resultSet.getString("login");
					String password = resultSet.getString("password");

					System.out.println("Fetched User from DB -> ID: " + id + ", Login: " + login);
				}
			}

		} catch (SQLException e) {
			System.err.println("Database connection failed!");
			e.printStackTrace();
		}
	}
}