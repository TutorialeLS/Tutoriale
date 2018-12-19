<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Witaj ${param.firstname }</title>
</head>
<body>
<h1>Witaj ${param.firstname } ${param.lastname}</h1>
	<jsp:useBean id="user"  class="pl.javastart.model.User" scope="session">
		<jsp:setProperty name="user" property="firstname" value="${param.firstname}" />
		<jsp:setProperty name="user" property="lastname" value="${param.lastname}" />
	</jsp:useBean>

	Atrybut ustawiony na podstawie parametru: ${sessionScope.user.firstname}<br>
	
	Równy: ${2 == 2} lub ${2 eq 2}<br>
	Różny: ${2 != 2}<br>
	Większy: ${2 > 2} lub ${2 gt 2}<br>
	Większy równy: ${2 >= 2} lub ${2 ge 2}<br>
	Mniejszy: ${2 < 2} lub ${2 lt 2}<br>
	Mniejszy równy: ${2 <= 2} lub ${2 le 2}<br>
	Koniunkcja: ${true && false} lub ${true and false}<br>
	Alternatywa: ${true || false} lub ${true or false}<br>
	Negacja: ${!true} lub ${not true}<br>
	Null check: ${empty header['user-agent']}<br>
	
	Twoja przeglądarka: ${header['user-agent'] }
</body>

</html>