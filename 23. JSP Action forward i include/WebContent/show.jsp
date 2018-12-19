<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twoje dane</title>
</head>
<body>
	<h1>Twoje dane:</h1>
	<jsp:useBean id="user" class="pl.javastart.jspa.model.User" scope="page">
		<jsp:setProperty property="*" name="user"/>
	</jsp:useBean>
	
	
	<p>Imię: <jsp:getProperty property="firstname" name="user"/></p>
	<p>Nazwisko: <jsp:getProperty property="lastname" name="user"/></p>
</body>
</html>