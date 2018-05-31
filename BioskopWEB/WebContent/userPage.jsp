<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>

	Ulogovani ste kao: ${user.username}<br>
	
	<a href="/BioskopWEB/commentForm.jsp">Komentarisi film</a><br>
	<a href="/BioskopWEB/FilmoviServlet">Film</a><br>
	<a href="/BioskopWEB/FilmoviPoKategorijamaServlet">Zanr</a><br>
	<a href="/BioskopWEB/pregledKomentaraPage.jsp">Prikaz komentara za film</a><br>
	<a href="/BioskopWEB/RezevrvacijaKarte">Rezervacija karte</a>
	
	<br>
	
	<form action="/BioskopWEB/LogOutServlet" method="get">
		<input type="submit" value="Log out"/>
	</form>
	
</body>
</html>