<%--                                                                         Zasieg request
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String login = request.getParameter("login");
	if(request.getAttribute("login") == null)
		request.setAttribute("login", login);
%>
--%>
<!--  
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
-->
<%-- 																			Zasieg session
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! String login; %>
<%
	login = request.getParameter("login");
	if(session.getAttribute("login") == null)
		session.setAttribute("login", login);
%>
--%>
<!--  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Witaj <%= session.getAttribute("login") %></title>
</head>
<body>
	<h1>Witaj <%= session.getAttribute("login") %></h1>
</body>
</html>
-->
<%--                                                                          zasieg aplikacji
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! String login; %>
<%
	login = request.getParameter("login");
	if(application.getAttribute("login") == null)
		application.setAttribute("login", login);
%>
--%>
<!--  																						
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Witaj <%= application.getAttribute("login") %></title>
</head>
<body>
	<h1>Witaj <%= application.getAttribute("login") %></h1>
</body>
</html>
-->
<!--                                                                                      Tylko zasieg strony -->
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
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
    <h2>Witaj, Twój adres IP: <%= request.getRemoteAddr() %></h2>
	<h1>Witaj <%= pageContext.getAttribute("login") %></h1>
</body>
</html>