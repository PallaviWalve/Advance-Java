package it.education.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import it.education.entity.*;
import education.jdbc.utils.*;
import it.education.entity.Course;

public class EducationDao implements DaoInterface<Course, Integer> {



		@Override
		public Collection<Course> retrieveAll() {
			//Creating an empty Collection of Customers
			Collection<Course> allCourse = new ArrayList<>();
			//Some code to get data from database and fill that
			//into this collection
			String sqlQuery = 
					"select course_name, course_provider, course_id, course_duration, course_fees from Course_Master";
			try(
					Connection dbConnection = JdbcUtils.buildConnection();
					Statement stmt = dbConnection.createStatement();
					ResultSet rs = stmt.executeQuery(sqlQuery)
					){
				while(rs.next()) {
					String course_name = rs.getString(1);
					String course_provider = rs.getString(2);
					int course_id = rs.getInt(3);
					int duration = rs.getInt(4);
					int fees = rs.getInt(5);
					//Populating an object of Customer class based 
					//upon: ID, name and address
					Course currentCourse = 
							new Course(course_id,course_name,course_provider,duration,fees);
					//Adding this object into customer's collection
					allCourse.add(currentCourse);
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return allCourse;
		}

		@Override
		public Course retrieveOne(Integer id) {
			// Fetching single customer against ID and returning it.
			Course foundCourse = null;
			String sqlQuery = 
			"select course_name, course_provider, course_id from Course_Master where course_id = ?";
			try(
					Connection dbConnection = JdbcUtils.buildConnection();
					PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
					){
				pstmt.setInt(1, id);
				ResultSet rs =  pstmt.executeQuery();
				if(rs.next()) {//If Customer exists
					
					String name = rs.getString(1);
					String provider = rs.getString(2);
					int course_id = rs.getInt(3);
					int duration = rs.getInt(4);
					int fees = rs.getInt(5);
					
					foundCourse = new Course(course_id, name, provider, duration, fees);
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			return foundCourse;
		}

		@Override
		public void create(Course courseRef) {
			String sqlQuery = 
			"insert into customer values(?,?,?,?,?)";
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
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}

		@Override
		public void delete(Integer id) {
			String sqlQuery = 
			"delete from customer where custid = ?";
			try(
					Connection dbConnection = JdbcUtils.buildConnection();
					PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
					){
				pstmt.setInt(1, id);
				int updateCount = pstmt.executeUpdate();
				System.out.println(updateCount + " record deleted");
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}

		@Override
		public void update(Course modifiedCourse) {
			
			String sqlQuery = "Update Course_Masetr set course_name = ?, course_provider = ?, course_duration =?, course_fees where custid = ?";
			int id = modifiedCourse.getCourse_id();
			String newname = modifiedCourse.getCourse_name();
			String newprovider = modifiedCourse.getCourse_provider();
			int newduration = modifiedCourse.getDuration();
			int newfee = modifiedCourse.getFees();
					try(
							Connection dbConnection = JdbcUtils.buildConnection();
							PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
							){
						
						pstmt.setString(1, newname);
						pstmt.setString(2,newprovider);
						pstmt.setInt(3, id);
						pstmt.setInt(4,newduration);
						pstmt.setInt(5,newfee);
						
						int updateCount = pstmt.executeUpdate();
						System.out.println(updateCount + " record updated");
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					
				}

			
		}
		




