<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pregled komentara za film</title>
</head>
<body>

	<form action="/BioskopWEB/PrikazKomentaraServlet" method="post">
		<input type="submit" value="Ucitaj filmove">
	</form>
	
	<br>
	
	<form action="/BioskopWEB/PrikazKomentaraServlet" method="get">
		Odaberite film:<select name="film">
			<c:forEach items="${sviKomentarisaniFilmovi}" var="f">
				<option value="${f.naziv}">${f.naziv }</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="Prikazi komentare"/>
	</form>
	
	<br>
	
	<h3>Komentari:</h3>
	<hr>
	
	<table>
		<c:forEach items="${komentari}" var="k">
			<tr>
				<td>${k.korisnik.username }:</td>
				<td>${k.tekst }</td>
			</tr>
		</c:forEach>	
	</table>

</body>
</html>