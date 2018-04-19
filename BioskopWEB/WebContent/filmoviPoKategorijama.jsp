<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/BioskopWEB/FilmoviPoKategorijamaServlet">
		<c:set var = "filmoviPoKategoriji" scope = "session" value = "${filmoviPoKategoriji}"/>
		<c:choose>
			<c:when test="${empty filmoviPoKategoriji}">
       			  <c:forEach var = "i" begin = "1" end = "5">
			         {filmoviPoKategroijama.ime}
			      </c:forEach>
    		</c:when>
			<c:otherwise>
        		Odaberite kategoriju.
    		</c:otherwise>
		</c:choose>
	</form>
</body>
</html>