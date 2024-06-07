package one_to_one.unidirectional.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_one.unidirectional.entity.Employee;
import one_to_one.unidirectional.entity.Passport;
import utils.HibernateUtils;

public class LinkPassportsToEmployeesExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
			){
			Class<Passport> passportType = Passport.class;
			Class<Employee> employeeType = Employee.class;
			
			
			Passport p1 = sessionRef.find(passportType, "P123");
			Passport p2 = sessionRef.find(passportType, "P456");
			
			Employee e1 = sessionRef.find(employeeType, 123);
			Employee e2 = sessionRef.find(employeeType, 456);
			
			Transaction tx = sessionRef.beginTransaction();
			e1.setPassportRef(p1);
			e2.setPassportRef(p2);
			tx.commit();
			
			System.out.println("Passport linked to Employees");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
