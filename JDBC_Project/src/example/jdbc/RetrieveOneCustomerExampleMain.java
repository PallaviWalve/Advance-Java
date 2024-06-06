package example.jdbc;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class RetrieveOneCustomerExampleMain {

	public static void main(String[] args) {
		DaoInterface<Customer, Integer> daoRef
			= new CustomerDao();
		Customer customerRef = daoRef.retrieveOne(4);
		if(customerRef != null)
			System.out.println(customerRef);
		else
			System.out.println("Customer with given ID does not exist.");

	}

}
