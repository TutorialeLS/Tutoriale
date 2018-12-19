<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%! String login; %>
<%
    login = request.getParameter("login");
    if(request.getAttribute("login") == null)
        request.setAttribute("login", login);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Witaj <%= request.getAttribute("login") %></title>
</head>
<body>
    <h1>Witaj <%= request.getAttribute("login") %></h1>
</body>
</html>