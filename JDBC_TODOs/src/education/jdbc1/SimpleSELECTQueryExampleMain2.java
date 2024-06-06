package education.jdbc1;

import java.util.Collection;

import it.education.dao.*;
import it.education.*;
import it.education.entity.*;

public class SimpleSELECTQueryExampleMain2 {

	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef
				= new EducationDao();
		Collection<Course> allCourses = 
				daoRef.retrieveAll();
		for(Course course : allCourses) {
			System.out.println(course);
		}
	}
}
