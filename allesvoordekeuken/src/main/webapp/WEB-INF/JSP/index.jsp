<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
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
            <li><a href="/artikels/toevoegen.htm">Artikels toevoegen</a></li>
            <li><a href="/artikels/zoekenopnaam.htm">Artikels zoeken op naam</a></li>
            <li><a href="/artikels/prijsverhoging.htm">Prijsverhoging</a></li>
            <li><a href="/artikels/kortingen.htm">Artikelkortingen</a></li>
            <li><a href="/artikels/perartikelgroep.htm">Artikels per artikelgroep</a></li>
        </ul>
    </nav>
    <img src="/images/logo${randomLogo}.jpg"/>
</header>
</body>
</html>
