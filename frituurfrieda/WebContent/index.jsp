<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@page import='java.io.PrintWriter'%> 
<%@page import='java.util.Calendar'%>
<!doctype html>
<html>
<head>
<title>Frituur Frieda</title>
</head>
<body>
	<h1>
	<% 
		int dag = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		if(dag == Calendar.MONDAY || dag == Calendar.THURSDAY){
			out.print("Vandaag zijn we gesloten.");
		} else {
			out.print("Vandaag zijn we open.");
		}
	%>
	</h1>
</body>
</html>