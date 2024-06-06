package education.jdbc1;

import it.education.dao.*;
import it.education.*;
import it.education.entity.*;

public class RetrieveOneCourseExampleMain {
	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef
			= new EducationDao();
		Course customerRef = daoRef.retrieveOne(4);
		if(customerRef != null)
			System.out.println(customerRef);
		else
			System.out.println("Course with given ID does not exist.");

	}
}
