<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Strona główna</h1> 
	<form action="show.jsp" method="POST">
		Imię: <input type="text" name="firstname">
		<br>
		Nazwisko: <input type="text" name="lastname">
		<br>
		<input type="submit" value="Wyślij">
	</form>
</body>
</html>