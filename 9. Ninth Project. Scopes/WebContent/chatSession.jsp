<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!String login;%>
<%
	login = request.getParameter("login");
	if (session.getAttribute("login") == null)
		session.setAttribute("login", login);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Witaj <%=session.getAttribute("login")%></title>
</head>
<body>
	<h1>
		Witaj
		<%=session.getAttribute("login")%></h1>
	<form action="index.jsp" method="post">
		<input type="submit" value="Wyślij">
	</form>
</body>
</html>