package example.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import example.spring.mvc.model.User;
import example.spring.mvc.model.UserValidator;

@Controller //This marks the class as a controller
public class SpringMvcController {

	@RequestMapping("/greet") //This marks the method as request mapping
	public String getIndexPage() {
		//This method get invoked when client requests for  the resource with URL: /greet
		System.out.println("Request Received");
		return "index";
	}
	
	@RequestMapping("/showLogin")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/doValidate", method = RequestMethod.POST)
	public String doValidateUser(
			@RequestParam("user_name") String uid, 
			@RequestParam("user_password") String pwd
			) {  //this method is called when client hit the /doValidate and request for Post
				User userObj = new User(uid,pwd); 
				boolean valid = UserValidator.isValid(userObj);
				String resultPage = "failure";
				if(valid)
					resultPage = "success";
				return resultPage;
	}
}
