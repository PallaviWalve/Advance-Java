package one_to_many.unidirectional.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_many.unidirectional.entity.CricketTeam;
import utils.HibernateUtils;

public class CreateCricketTeamExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
			){
			CricketTeam teamIndia = new CricketTeam("IND", "India", null);
			CricketTeam teamAustralia = new CricketTeam("AUS", "Australia", null);
			
			Transaction tx = sessionRef.beginTransaction();
			sessionRef.persist(teamIndia);
			sessionRef.persist(teamAustralia);
			
			tx.commit();
			System.out.println("Teams Created");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
