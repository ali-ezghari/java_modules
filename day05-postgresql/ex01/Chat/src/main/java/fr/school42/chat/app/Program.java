package main.java.fr.school42.chat.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import main.java.fr.school42.chat.repositories.*;

import java.sql.SQLException;

public class Program {

	private static final String DB_URL = "jdbc:postgresql://localhost:5432/chat_db";
	private static final String DB_USER = "aezghari";
	private static final String DB_PASSWORD = "secretpassword";

	public static void main(String[] args) {

		// Create a hikariConfig object to store our database credentials
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(DB_URL);
		config.setUsername(DB_USER);
		config.setPassword(DB_PASSWORD);
		config.setDriverClassName("org.postgresql.Driver"); // specifying which driver to use

		DataSource dataSource = new HikariDataSource(config); // creating a connections pool
		MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a message ID\n -> ");
		try {
			repository.findById(scanner.nextLong());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		scanner.close();

	}
}
