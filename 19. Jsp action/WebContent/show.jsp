<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twoje dane</title>
</head>
<body>
	<h1>Twoje dane:</h1>
	<jsp:useBean id="user" class="pl.javastart.jspa.model.User" scope="page"><!-- tworzy obiekt user o zasiegi strony -->
		<jsp:setProperty property="*" name="user"/><!-- wpisuje wartosci podane w index.jsp do obiektu user -->
	</jsp:useBean>
	
	<p>Imię: <jsp:getProperty property="firstname" name="user"/></p><!--  pobiera wskazane pola z obiektu user -->
	<p>Nazwisko: <jsp:getProperty property="lastname" name="user"/></p><!--  pobiera wskazane pola z obiektu user -->
</body>
</html>