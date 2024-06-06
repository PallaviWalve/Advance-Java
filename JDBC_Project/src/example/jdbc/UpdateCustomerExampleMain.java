package example.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;
import java.sql.Connection;
import example.jdbc.dao.CustomerDao;


public class UpdateCustomerExampleMain {

	public static void main(String[] args) {
		
		DaoInterface<Customer, Integer> daoRef = new CustomerDao();
		Customer customerRef = daoRef.retrieveOne(6);
		customerRef.setName("Sanket");
		customerRef.setAddress("Pune");
		daoRef.update(customerRef);
		
	}

}
