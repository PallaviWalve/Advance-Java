package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entertainment.entity.Movie;

public class RecordInsertionExampleMain {
	
	public static void main(String[] args) {
		//step 1 configure hibernate
		Configuration hibernateConfig = new Configuration();
		hibernateConfig = hibernateConfig.configure();
		
		//step 2 Obtain sessionFactory
		SessionFactory hibernateFactory = hibernateConfig.buildSessionFactory();
		
		//step 3 Obtain Session
		Session hibernateSession = hibernateFactory.openSession();
		
		//step 4 create object of entity class
		Movie movieObj = new Movie(103, "Singham", "Action", 2016);
		
		//step 5 start and obtain transaction
		Transaction hibernateTransaction = hibernateSession.beginTransaction();
		
		//step 6 save the object using session
		hibernateSession.persist(movieObj);
		
		//step 7 commit the transaction
		hibernateTransaction.commit();
		
		//step 8 close the session
		hibernateSession.close();
		
		//step 9 close the sessionFactory
		hibernateSession.close();
		
		System.out.println("Record Inserted...");
	}

}
