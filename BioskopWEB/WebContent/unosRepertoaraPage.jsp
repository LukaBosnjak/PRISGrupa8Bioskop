<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Unos repertoara</title>
</head>
<body>

	<h2>Unos repertoara</h2>
	
	<form action="/BioskopWEB/UnosRepertoaraServlet" method="post">
		Datum: <input type="date" name="datumRepertoar"/><br>
		Tip repertoara: <input type="text" name="tipRepertoara"/><br>
		Naziv filma: <input type="text" name="nazivFilma"/><br>
		Broj sale: <input type="text" name="brSale"/><br>
		<input type="submit" value="Unesi repertoar"/>
	</form>
	
	<br>
	
	${porukaRepertoar}
	
	<br>
	
	<a href="/BioskopWEB/adminPage.jsp">Povratak na pocetnu stranu</a>
</body>
</html>