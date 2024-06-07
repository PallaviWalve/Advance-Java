package main.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordDeleteExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory sf = HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
			){
			Class<Movie> entityType = Movie.class;
			Object identity = 105; //identity =new Integer(104);
			Movie foundMovie =  sessionRef.find(entityType, identity);
			
			Transaction tx = sessionRef.beginTransaction();
			sessionRef.remove(foundMovie);
			tx.commit();
			
			System.out.println("Record Deleted");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
