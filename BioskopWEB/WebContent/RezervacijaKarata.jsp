<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${successMessage}
	<c:choose>
		<c:when test="${not empty projekcije}">
			<table>
				<tr>
					<th>Projekcije</th>
				</tr>
				<c:forEach items="${projekcije}" var="pro">
					<tr>
						<td>
							${pro.film.naziv }
						</td>
						<td>
							<form action="/BioskopWEB/RezervacijaKarte" method="POST">
								<input type="hidden" name="idProjekcije" value="${pro.idProjekcije}"/>
								<input type="Submit" value="Rezervisi"/>
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