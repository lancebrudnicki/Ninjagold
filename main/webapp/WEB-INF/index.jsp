<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div>
		<label>Your Gold:</label>
		<p><c:out value="${userGold}"/></p>
	</div>
	<div style="display: flex; padding: 10px; margin: 10px;">
		<form method="POST" action="/process">
			<div style="padding: 10px; margin: 10px;">
				<h1>Farm</h1>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" name="gold" value="farm">
				<input type="submit" value="Find Gold">
			</div>
		</form>
		<form method="POST" action="/process">
			<div style="padding: 10px; margin: 10px;">
				<h1>Cave</h1>
				<p>(earns 5-10 gold)</p>
				<input type="hidden" name="gold" value="cave">
				<input type="submit" value="Find Gold">
			</div>
		</form>
		<form method="POST" action="/process">
			<div style="padding: 10px; margin: 10px;">
				<h1>House</h1>
				<p>(earns 2-5 gold)</p>
				<input type="hidden" name="gold" value="house">
				<input type="submit" value="Find Gold">
			</div>
		</form>
		<form method="POST" action="/process">
			<div style="padding: 10px; margin: 10px;">
				<h1>Casino!</h1>
				<p>(earns/takes 50 gold)</p>
				<input type="hidden" name="gold" value="casino">
				<input type="submit" value="Find Gold">
			</div>
		</form>
		<form method="POST" action="/process">
			<div style="padding: 10px; margin: 10px;">
				<h1>Spa.....it is worthless!</h1>
				<p>(takes 5-20 gold)</p>
				<input type="hidden" name="gold" value="spa">
				<input type="submit" value="Find Gold">
			</div>
		</form>
	</div>
	<div>
		<h1>Activities</h1>
		<div>
			<c:forEach var ="event" items="${activityList}">
				<p><c:out value="${event}"/></p>
			</c:forEach>
		</div>
	
	</div>

</body>
</html>