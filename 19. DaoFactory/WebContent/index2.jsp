<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Library Viewer</title>
</head>
<body>	
<h1>User viewer</h1>
	<form action="UserServlet" method="post">
		<input placeHolder="pesel" type="text" name="pesel"><p>pesel</p>
		<br>
		<input placeHolder="firstname" type="text" name="firstname"><p>imie</p>
		<br>
		<input placeHolder="lastname" type="text" name="description"><p>nazwisko</p>
		<br>
		Szukaj: <input type="radio" name="option" value="search"> Dodaj: <input type="radio" name="option" value="add">
		Modyfikuj: <input type="radio" name="option" value="update"> Usuń: <input type="radio" name="option" value="delete">
		<br>
		<input type="submit" value="Wyślij">
	</form>

</body>
</html>