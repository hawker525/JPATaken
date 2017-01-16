<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<!doctype html>
<html lang='nl'>
    <head>
        <title>Alles Voor De Keuken</title>
        <link rel='icon' href='<c:url value="/images/favicon.ico"/>'>
    </head>
<body>
<header>
    <nav>
        <ul>
            <li><a href=<c:url value="/artikels/zoekenopnummer.htm"/>>Artikels zoeken op nummer</a></li>
            <li><a href=<c:url value="/artikels/toevoegen.htm"/>>Artikels toevoegen</a></li>
            <li><a href=<c:url value="/artikels/zoekartikelopnaam.htm"/>>Artikels zoeken op naam</a></li>
            <li><a href="/artikels/prijsverhoging.htm">Prijsverhoging</a></li>
            <li><a href="/artikels/kortingen.htm">Artikelkortingen</a></li>
            <li><a href="/artikels/perartikelgroep.htm">Artikels per artikelgroep</a></li>
        </ul>
    </nav>
</header>
<h1>Artikels zoeken op naam</h1>
<form>
	<label>
		Naam:
		<input name="naam" type="text" autofocus required />
		<input type="submit" value="Zoeken" />
	</label>
</form>
<c:if test="${not empty artikels}">
	<table>
	<tr><th>nummer</th><th>naam</th><th>aankoopprijs</th><th>verkoopprijs</th></tr>
	<c:forEach items="${artikels}" var="artikel">
		<tr>
			<td>${artikel.id}</td>
			<td>${artikel.naam}</td>
			<td>${artikel.aankoopprijs}</td>
			<td><fmt:formatNumber value="${artikel.verkoopprijs}" minFractionDigits="2" maxFractionDigits="2" /></td>
		</tr>	
	</c:forEach>
	</table>
</c:if>
</body>
</html>
