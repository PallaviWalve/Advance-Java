<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<body bgcolor = "wheat">
		<h2>Please Sign In :</h2>
			<form action = "doValidate" method="post">
				<pre>
					User Name: <input type="text" name="user_name"/>
					
					Password:  <input type="password" name="user_password"/>
					
					<input type="submit" value = "Sign IN"/>
				</pre>
			</form>
		</body>
	</html>