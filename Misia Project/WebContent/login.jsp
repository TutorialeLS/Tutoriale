<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zaloguj się</title>
</head>
<body>
    <h2>Zaloguj się</h2>
    <form action="LoginServlet" method="POST">
        Username: <input type="text" name="username">
        <br>
        Password: <input type="password" name="password">
        <br>
        <input type="submit" value="Zaloguj">
    </form>
</body>
</html>