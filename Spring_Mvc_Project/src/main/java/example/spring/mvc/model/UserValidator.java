package example.spring.mvc.model;

public class UserValidator {

	public static boolean isValid(User currentUserRef) {
		String currentUserName = currentUserRef.getUserId();
		String currentUserPassword = currentUserRef.getPassword();
		boolean success = false;
		if(currentUserName.equals("admin") && currentUserPassword.equals("asAdmin"))
			success = true;
		return success;
	}
}
