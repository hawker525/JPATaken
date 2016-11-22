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
	<h2>Adres</h2>
	<p>${adres.straat} ${adres.huisNr}, ${adres.gemeente.postCode} ${adres.gemeente.naam}</p>
</body>
</html>