package education.jdbc1;

import it.education.dao.*;

import it.education.entity.*;

public class CreateNewCourseExampleMain {

	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef
		= new EducationDao();
		Course courseObj = 
				new Course(6, "React", "Infinite" ,150, 30000);
		daoRef.create(courseObj);

	}
}
