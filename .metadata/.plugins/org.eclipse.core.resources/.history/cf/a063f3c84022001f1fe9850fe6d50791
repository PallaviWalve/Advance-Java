package example.jdbc;

import java.util.Collection;

import example.jdbc.dao.EnhancedCustomerDao;
import example.jdbc.entity.Customer;

public class DaoEnhancementExampleMain {

	public static void main(String[] args) {
		
		EnhancedCustomerDao enhancedDaoRef = new EnhancedCustomerDao();
		Collection<Customer> customersWithMatchingCity = enhancedDaoRef.retrieveAllCustomersByCityName("Mumbai");
		
		int size = customersWithMatchingCity.size();
		if(size != 0) {
		for(Customer customerRef : customersWithMatchingCity)
			System.out.println(customerRef);
		}
		else {
			System.out.println("No customer found with the given city");
		}
	}

}
