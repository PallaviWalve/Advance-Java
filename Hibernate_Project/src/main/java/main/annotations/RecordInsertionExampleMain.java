package main.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordInsertionExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory sf = HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
			){
			Movie movieObj = new Movie(109, "Predator", "Horror", 1997);
			Transaction tx = sessionRef.beginTransaction();
			sessionRef.persist(movieObj);
			tx.commit();
			System.out.println("Record Inserted...");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
