<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pregled profita za odredjeni period</title>
</head>
<body>

	<h1>Pregled profita</h1>
	
	Unesite period za koji zelite pregled profita: <br>
	
	<form action="/BioskopWEB/PregledProfitaServlet" method="get">
		Od: <input type="date" name="datumOd"/><br>
		Do: <input type="date" name="datumDo"/><br>
		<input type="submit" value="Pregled"/>
	</form>
	
	<br>
	<br>
	
	${porukaProfit}

</body>
</html>