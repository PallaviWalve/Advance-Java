package hql.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import utils.HibernateUtils;

public class SELECTClauseExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory sf = HibernateUtils.getSessionFactory();
				Session sessionRef = sf.openSession();
			){
			String hqlQuery = "select m.title, m.year from Movie m";
			Query<Object[]> queryRef = sessionRef.createQuery(hqlQuery, Object[].class);
			List<Object[]> movieInfoList = queryRef.list();
			for(Object[] movieInfo : movieInfoList) {
			Object title = movieInfo[0];
			Object year = movieInfo[1];
			System.out.println("Movie: " + title + " was released in " + year);
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
