<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<!doctype html>
<html lang='nl'>
<head>
	Verkoopprijs verhoging
</head>
<body>
<h1>Algemene verhoging verkoopprijs</h1>
<form method='post' id='opslagform'>
    <label>Percentage:<span>${fouten.percentage}</span>
        <input name='percentage' value='${param.percentage}' type='number'
               min='0.01' step='0.01' autofocus></label>
    <input type='submit' value='Opslag' id='submitknop'>
</form>
<script>
    document.getElementById('opslagform').onsubmit = function() {
        document.getElementById('submitknop').disabled = true;
    };
</script>
</body>
</html>