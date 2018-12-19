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
	<form action="show.jsp">
		Imię: <input type="text" name="first">
		<br>
		Nazwisko: <input type="text" name="last">
		<br>
		<input type="submit" value="Wyślij">
	</form>
	<a href="forward.jsp">Forward</a>
	<br>
	<a href="include.jsp">Include</a>
</body>
</html>