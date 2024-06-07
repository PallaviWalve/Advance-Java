package main.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordRetrievalExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory sf = HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
			){
			Class<Movie> entityType = Movie.class;
			Object identity = 105; //identity =new Integer(104);
			Movie foundMovie =  sessionRef.find(entityType, identity);
			//select * from movie_master_details where movie_id = ?; ?---->104
			
			if(foundMovie!= null) {
				System.out.println(foundMovie);
				System.out.println("Movie Title : " +foundMovie.getTitle());
			}
			else
				System.out.println("Movie with given ID does not exist");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
