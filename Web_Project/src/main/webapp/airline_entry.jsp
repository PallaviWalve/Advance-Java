<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body bgcolor="cyan">
		<h1>Airline Details:</h1>
		<form action="create_airline.jsp" method="post">
			<pre>
				Code: 		<input type="text" name="code"/>
				
				Name: 		<input type="text" name="name"/>
				
				Employee Count: <input type="text" name="employeeCount"/>
				
							<input type="submit" value="CREATE"/>
				
			</pre>
		</form>
		
	</body>
</html>