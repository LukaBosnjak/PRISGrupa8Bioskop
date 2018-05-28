<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/BioskopWEB/ProdajaKarteServlet" method="POST">
		<input type="Submit" value="Prodaj Kartu"/>
	</form>
	<c:choose>
		<c:when test="${not empty rezervacije}">
			<table>
				<tr>
					<th>Rezervacije</th>
				</tr>
				<c:forEach items="${rezervacije}" var="rez">
					<tr>
						<td>
							${rez.korisnik.username }
						</td>
						<td>
							<form action="/BioskopWEB/ProdajaRezervisaneKarteServlet" method="POST">
								<input type="hidden" name="idRezervacije" value="${rez.idRezervacije}"/>
								<input type="Submit" value="Prodaj Kartu"/>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>Nema rezrevacija</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>