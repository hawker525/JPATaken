<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!doctype html>
<html lang='nl'>
<head>
    <title>Kortingen van artikels</title>
</head>
<body>
<h1>Kortingen van artikels</h1>
<ul>
	<c:forEach items="${artikels}" var="artikel">
		<li>
			<c:url value="/artikels/kortingen.htm" var="artikelLink">
				<c:param name="id" value="${artikel.id}"/>
			</c:url>
			<a href="${artikelLink}">${artikel.naam}</a>
		</li>
	</c:forEach>
</ul>
<c:if test="${not empty kortingArtikel}">
	<h2>Details kortingen voor ${kortingArtikel.naam}</h2>
	<c:forEach items="${kortingArtikel.kortingen}" var="korting">
		<p>Vanaf ${korting.vanafAantal} aankopen krijg je ${korting.kortingsPercentage}% korting!</p>
	</c:forEach>
</c:if>
</body>
</html>