package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.entity.Customer;
import example.jdbc.utils.JdbcUtils;

public class CustomerDao implements DaoInterface<Customer, Integer>{

	@Override
	public Collection<Customer> retrieveAll() {
		//Creating an empty Collection of Customers
		Collection<Customer> allCustomers = new ArrayList<>();
		//Some code to get data from database and fill that
		//into this collection
		String sqlQuery = 
				"select cname, address, custid from customer";
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
				allCustomers.add(currentCustomer);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return allCustomers;
	}

	@Override
	public Customer retrieveOne(Integer id) {
		// Fetching single customer against ID and returning it.
		Customer foundCustomer = null;
		String sqlQuery = 
		"select cname, address, custid from customer where custid = ?";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
				){
			pstmt.setInt(1, id);
			ResultSet rs =  pstmt.executeQuery();
			if(rs.next()) {//If Customer exists
				String name = rs.getString(1);
				String address = rs.getString(2);
				int cust_id = rs.getInt(3);
				foundCustomer = new Customer(cust_id, name, address);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return foundCustomer;
	}

	@Override
	public void create(Customer customerRef) {
		String sqlQuery = 
		"insert into customer values(?,?,?)";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
				){
				//Retrieving data from customerRef
				int custId = customerRef.getCustomerId();
				String custName = customerRef.getName();
				String custAddress = customerRef.getAddress();
				
				//Setting the data in place of unknown parameters.
				pstmt.setInt(1, custId);
				pstmt.setString(2, custName);
				pstmt.setString(3, custAddress);
				
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
	public void update(Customer modifiedCustomer) {
		
		String sqlQuery = "Update customer set cname = ?, address = ? where custid = ?";
		int id = modifiedCustomer.getCustomerId();
		String newname = modifiedCustomer.getName();
		String newaddress = modifiedCustomer.getAddress();
				try(
						Connection dbConnection = JdbcUtils.buildConnection();
						PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
						){
					
					pstmt.setString(1, newname);
					pstmt.setString(2,newaddress);
					pstmt.setInt(3, id);
					int updateCount = pstmt.executeUpdate();
					System.out.println(updateCount + " record updated");
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}

		
	}
	


