<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@page import='java.io.PrintWriter'%> 
<%@page import='java.util.Calendar'%>
<!doctype html>
<html>
<head>
<title>Frituur Frieda</title>
</head>
<body>
	<h1>Vandaag zijn we ${openGesloten}</h1>
	<img src="images/${openGesloten}.png" />
</body>
</html>