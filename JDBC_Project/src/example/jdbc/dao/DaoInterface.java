package example.jdbc.dao;

import java.util.Collection;
//This interface provides a basic template for the DAO pattern
//Its implementation class decides the actual entity type
//and the ID type.
public interface DaoInterface<T, K> {
	Collection<T> retrieveAll();
	T retrieveOne(K id);
	void create(T t);
	void delete(K id);
	void update(T t);
}

//Customer ID: int --> Integer ----> CustomerDao<Customer, Integer>
//Passport ID: String -------> PassportDao<Passport, String>









	
