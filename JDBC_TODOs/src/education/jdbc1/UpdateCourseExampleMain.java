package education.jdbc1;

import it.education.dao.*;
import it.education.*;
import it.education.entity.*;

public class UpdateCourseExampleMain {
public static void main(String[] args) {
		
		DaoInterface<Course, Integer> daoRef = new EducationDao();
		Course courseRef = daoRef.retrieveOne(6);
		courseRef.setCourse_name("CPP");
		courseRef.setCourse_provider("Prepcrazy");
		daoRef.update(courseRef);
		
	}
}
