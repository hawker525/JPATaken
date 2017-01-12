<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<!doctype html>
<html lang='nl'>
<head>
    <title>Artikel zoeken</title>
</head>
<body>
<h1>Artikel zoeken</h1>
<form>
    <label>Nummer:<span>${fouten.id}</span>
        <input name='id' value='${param.id}'
               required autofocus type='number' min='1'></label>
    <input type='submit' value='Zoeken'>
</form>
<c:if test='${not empty param and empty fouten and empty artikel}'>
    artikel niet gevonden
</c:if>
<c:if test='${not empty artikel}'>
    Naam: ${artikel.naam}, aankoopprijs: ${artikel.aankoopprijs}, verkoopprijs: ${artikel.verkoopprijs}, winst: ${winstPercent}%
</c:if>
</body>
</html>