<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zaloguj do czatu</title>
</head>
<body>
    <h1>Nazwa użytkownika: </h1>
    <form action="chatSession.jsp" method="post">
        <input type="text" name="login">
        <input type="submit" value="Wyślij">
    </form>
<%!String login;%>
<%
	login = request.getParameter("login");
	if (session.getAttribute("login") != null)%>
		<%=session.getAttribute("login")%>
</body>
</html>