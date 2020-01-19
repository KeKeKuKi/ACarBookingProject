package dao.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTool {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	 	
		Connection con = null;
		String uri ="jdbc:mysql://39.107.234.216/kekekuki?useSSL=true&characterEncoding=UTF-8"; 
		try {
			con = DriverManager.getConnection(uri, "kekekuki", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 	 
		return con;
	}
}
