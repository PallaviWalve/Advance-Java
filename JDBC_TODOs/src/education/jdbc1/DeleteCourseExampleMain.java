package education.jdbc1;
import it.education.dao.*;
import it.education.dao.*;
import it.education.entity.*;

public class DeleteCourseExampleMain {
	
	
	
		public static void main(String[] args) {
			DaoInterface<Course, Integer> daoRef
			= new EducationDao();
			daoRef.delete(2);

		}

	}


