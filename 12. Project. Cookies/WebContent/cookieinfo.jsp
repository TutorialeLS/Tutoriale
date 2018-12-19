<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All cookies</title>
</head>
<body>
    <%
      if(request.getCookies() != null)
        for(Cookie c: request.getCookies()) {
     %>
        <%= c.getName() + " > " + c.getValue() %>
        <br>
     <%
        }
      %>
      <a href="CookieServlet?cookie=print">Refresh page</a>
      <br>
      <a href="index.jsp">Homepage</a>
</body>
</html>