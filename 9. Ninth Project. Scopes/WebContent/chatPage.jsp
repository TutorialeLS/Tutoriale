<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%! String login; %>
<%
    login = request.getParameter("login");
    if(pageContext.getAttribute("login") == null)
        pageContext.setAttribute("login", login);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Witaj <%= pageContext.getAttribute("login") %></title>
</head>
<body>
    <h1>Witaj <%= pageContext.getAttribute("login") %></h1>
</body>
</html>