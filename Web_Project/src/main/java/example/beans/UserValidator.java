package example.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import example.utils.JdbcUtils;

public class UserValidator {

	public static boolean isValid(User currentUserRef) {
		boolean success = false;
//		code to interact with DB and return boolean value
		String sqlQuery = "select * from app_users where user_id = ? and user_pwd = ?"; //we get 1 record or zero record
		try (
			Connection dbConnection = JdbcUtils.buildConnection();
			PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
		){
			String currentUserName = currentUserRef.getUserId();
			String currentUserPassword = currentUserRef.getPassword();
			pstmt.setString(1, currentUserName);
			pstmt.setString(2, currentUserPassword);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())  //check if user is valid
				success = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}