package example.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	//A utility class used for establishing a Connection
	public static Connection buildConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String URL = "jdbc:mysql://localhost:3306/cdac";
		String UID = "root";
		String PWD = "root";
		Connection dbConnection = 
				DriverManager.getConnection(URL, UID, PWD);
		return dbConnection;
	}
}








