package example.jdbc;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class CreateNewCustomerExampleMain {

	public static void main(String[] args) {
		DaoInterface<Customer, Integer> daoRef
		= new CustomerDao();
		Customer customerObj = 
				new Customer(6, "Sanket", "Nagpur");
		daoRef.create(customerObj);

	}

}
