package Tiago.Pratica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final String URL = "jdbc:mysql://localhost:3306/games?serverTimezone=UTC";
	private final String USER = "root";
	private final String password = "";
	private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	private Connection createConnection() throws SQLException {
		Connection connection = null;
		
		try {
			Class.forName(DRIVER_CLASS);
			connection = DriverManager.getConnection(URL, USER, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public Connection getConnetion() {
		try {
			return createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
