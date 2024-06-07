<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body>
		<h2>Showing Airline Details</h2>
		<%--Obtaining a bean from session scope --%>
		<jsp:useBean id="airlineRef" 
					 class="travel.Airline" 
					 scope="session"/>
					 
		<%--Fetching its data using<jsp:getProperty --%>
		<h2>Code: <jsp:getProperty property="code" name="airlineRef"/></h2>
		<h2>Name: <jsp:getProperty property="name" name="airlineRef"/></h2>
		<h2>Employee Count: <jsp:getProperty property="employeeCount" name="airlineRef"/></h2>
	</body>
</html>