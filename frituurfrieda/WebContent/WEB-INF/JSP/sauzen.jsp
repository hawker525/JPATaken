<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import='java.io.PrintWriter'%> 
<%@page import='java.util.Calendar'%>
<!doctype html>
<html>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp' >
		<c:param name='title' value='Sauzen' />	
	</c:import>
</head>
<body>
	<h1>Sauzen</h1>
	<ul>
		<c:forEach var="saus" items="${sauzen}">
			<li>
			${saus.naam}, ingredienten: 
			${fn:join(saus.ingredienten.toArray() , ",")}
			<img src="images/${saus.naam}.png" />
			</li>
		</c:forEach>
	</ul>
</body>
</html>