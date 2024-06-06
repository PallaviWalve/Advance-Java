package example.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.entity.Customer;
import example.jdbc.utils.JdbcUtils;

public class EnhancedCustomerDao extends CustomerDao {
	
	public Collection<Customer> retrieveAllCustomersByCityName(String cityName){
		
		Collection<Customer> allCustomerWithMatchingCityName = new ArrayList<>();
		
		String sqlQuery = "select cname , address, custid from customer where address = ? ";
				
				try(
						Connection dbConnection = JdbcUtils.buildConnection();
						Statement stmt = dbConnection.createStatement();
						ResultSet rs = stmt.executeQuery(sqlQuery)
						){
					while(rs.next()) {
						String name = rs.getString(1);
						String address = rs.getString(2);
						int id = rs.getInt(3);
						//Populating an object of Customer class based 
						//upon: ID, name and address
						Customer currentCustomer = 
								new Customer(id, name, address);
						//Adding this object into customer's collection
						allCustomerWithMatchingCityName.add(currentCustomer);
					}
		
	}
		catch (Exception e) {
			e.printStackTrace();
		}

		return allCustomerWithMatchingCityName;
}
}
