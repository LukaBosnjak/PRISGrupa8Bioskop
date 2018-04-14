<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>

	<form action="/BioskopWEB/RegistracijaServlet" method="post">
		Username: <input type="text" name="imeRegister"/><br>
		Password: <input type="password" name="prezRegister"/><br>
		Role: <input type="text" name="mailRegister"/><br>
		Image: <input type="file" value="Upload" name="image"/><br>
		<input type="submit" value="Registruj se"/>
	</form>
	
	${poruka} <br>
	
	<a href="/BioskopWEB/index.jsp">Povratak na pocetnu stranicu</a>

</body>
</html>