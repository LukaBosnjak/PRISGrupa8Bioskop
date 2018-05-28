<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Komentarisi film</title>
</head>
<body>
	
	<form action="/BioskopWEB/KomentarServlet" method="get">
		<input type="submit" value="Ucitaj filmove">
	</form>
	
	<br>

	<form action="/BioskopWEB/KomentarServlet" method="post">
		Film: <select name="film">
			<c:forEach items="${sviFilmovi}" var="f">
				<option value="${f.naziv}">${f.naziv }</option>
			</c:forEach>
		</select><br>
		<!-- Film: <input type="text" name="film"/><br>-->
		Komentar: <textarea rows="10" cols="30" name="komentar"></textarea><br>
		<input type="submit" value="Comment"/>
	</form>
	
	<br>
	
	${porukaComment}
	
	<a href="/BioskopWEB/userPage.jsp">Nazad</a>

</body>
</html>