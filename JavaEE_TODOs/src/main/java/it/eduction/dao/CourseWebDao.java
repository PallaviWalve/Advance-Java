package it.eduction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import it.education.utils.JdbcUtils;
import it.eduction.entity.Course;

//import education.jdbc.utils.JdbcUtils;
//import it.education.entity.Course;

public class CourseWebDao {

		public boolean addCourse(Course courseRef) {
			String sqlQuery = 
			"insert into Course_Master values(?,?,?,?,?)";
			try(
					Connection dbConnection = JdbcUtils.buildConnection();
					PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
					){
					//Retrieving data from customerRef
					int course_id = courseRef.getCourse_id();
					String course_name = courseRef.getCourse_name();
					String course_provider = courseRef.getCourse_provider();
					int duration = courseRef.getDuration();
					int fees = courseRef.getFees();
					
					
					//Setting the data in place of unknown parameters.
					pstmt.setInt(1, course_id);
					pstmt.setString(2, course_name);
					pstmt.setString(3, course_provider);
					pstmt.setInt(4, duration);
					pstmt.setInt(5, fees);
					
					int updateCount = pstmt.executeUpdate();
					System.out.println(updateCount + " record inserted.");
					return true;
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return false;
		}
}

