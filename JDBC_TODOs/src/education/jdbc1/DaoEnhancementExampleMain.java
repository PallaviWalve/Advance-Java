package education.jdbc1;

import java.util.Collection;

import it.education.dao.*;
import it.education.entity.*;

public class DaoEnhancementExampleMain {

	public static void main(String[] args) {
		
		EnhancedEducationDao enhancedDaoRef = new EnhancedEducationDao();
		Collection<Course> providersWithMatchingCourseName = enhancedDaoRef.retrieveAllCoursesByCourseName("Java");
		
		int size = providersWithMatchingCourseName.size();
		if(size != 0) {
		for(Course customerRef : providersWithMatchingCourseName)
			System.out.println(customerRef);
		}
		else {
			System.out.println("No provider found with the given course");
		}
	}

}
