<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculation result</title>
</head>
<body>
    <h2>
        <%= request.getAttribute("a") %> + <%= request.getAttribute("b") %>
        = <%= request.getAttribute("result") %>
    </h2>
</body>
</html>