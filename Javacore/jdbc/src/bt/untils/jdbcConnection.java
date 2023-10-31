package bt.untils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnection {
	public static jdbcConnection getInstance;
	public static Connection connection;
	
	static {
		if(getInstance==null) {
			getInstance = new jdbcConnection();
		}try {
			getInstance.getDBConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		String dbUrl ="jdbc:mysql://localhost:3307/bai1";
		String userName ="root";
		String password ="root";
		// đăng kí driver với driver manager 
		Class.forName("com.mysql.cj.jdbc.Driver");
		// tạo connection
		connection = DriverManager.getConnection(dbUrl, userName, password);
		return connection;
	}
}
