package it.education.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import it.education.entity.*;
import education.jdbc.utils.*;

public class EnhancedEducationDao extends EducationDao {
	
	public Collection<Course> retrieveAllCoursesByCourseName(String courseName){
		
		Collection<Course> allCourseWithMatchingCouseName = new ArrayList<>();
		
		String sqlQuery = "select cname , address, custid from customer where address = ? ";
				
				try(
						Connection dbConnection = JdbcUtils.buildConnection();
						Statement stmt = dbConnection.createStatement();
						ResultSet rs = stmt.executeQuery(sqlQuery)
						){
					while(rs.next()) {
						String name = rs.getString(1);
						String provider = rs.getString(2);
						int id = rs.getInt(3);
						int duration = rs.getInt(4);
						int fees = rs.getInt(5);
						//Populating an object of Customer class based 
						//upon: ID, name and address
						Course currentCourse = 
								new Course(id, name, provider,duration,fees);
						//Adding this object into customer's collection
						allCourseWithMatchingCouseName.add(currentCourse);
					}
		
	}
		catch (Exception e) {
			e.printStackTrace();
		}

		return allCourseWithMatchingCouseName;
}
}

