<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Deklaracja -->
<%! String name; %>
<!-- Inicjalizacja -->
<% name = "Jan Kowalski"; %>
 
    <!-- Wyrażenie -->
    <h1>Witaj <%= name %>!</h1>
     
    <!-- Skryptlet -->
    <% for(int i=0; i<5; i++) { %>

        <p>Paragraf numer <%= i %></p>
    <% } %>
</body>
</html>