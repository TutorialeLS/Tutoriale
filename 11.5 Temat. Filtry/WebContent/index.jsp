<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
	<h2>Witaj, Twój adres IP: <%= request.getRemoteAddr() %></h2>
	<a href="admin.jsp">Admin Panel</a>
</body>
</html>