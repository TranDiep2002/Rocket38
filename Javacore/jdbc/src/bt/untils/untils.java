package bt.untils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Statement;
import java.sql.ResultSet;

public class untils {
	public static Connection Connect() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		//Connection connection = null;
		String dbUrl ="jdbc:mysql://localhost:3307/bai1";
	
		Properties pro = new Properties();
		pro.load(new FileInputStream("src/main/resource/database.properties"));
		String userName = pro.getProperty("username");
		String pass = pro.getProperty("password");
		// đăng ký vs driver mânger
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// tạo connection
//		connection = DriverManager.getConnection(dbUrl,userName,pass);
//			if(connection!= null) {
//				System.out.print(" connection sucess!");
//			}
			return DriverManager.getConnection(dbUrl,userName,pass);
	}

	public static boolean login(String fullname, String pass)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		try (Connection connection = Connect()) {
			String sql = "select * from account1";
			PreparedStatement pstmt1 = connection.prepareStatement(sql);
			//pstmt1.setInt(1, 2);
			//pstmt1.setString(2, pass);
			ResultSet rs = pstmt1.executeQuery(sql);
			if (rs.next()) {
				System.out.print("�?ăng nhập thành công");
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.print("đăng nhập không thành công");
			return false;
		}
		return true;
	}
}
