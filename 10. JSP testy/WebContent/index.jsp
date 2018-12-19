<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Formularz</title>
</head>
<body>
    <h1>Podaj swoje dane:</h1>
    <form action="HomeServlet" method="post">
        <!-- Reszta kodu bez zmian -->
        Imie użytkownika: <br>
        <input type="text" name="firstName"><br>
        Nazwisko użytkownika: <br>
        <input type="text" name="lastName"><br>
 		Wiek uzytkownika: <br>
        <input type="text" name="age"><br>
        <input type="submit" value="Wyślij">
    </form>
</body>
</html>