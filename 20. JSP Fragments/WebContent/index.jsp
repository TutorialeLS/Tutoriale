<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona główna</title>
</head>
<body>
	<jsp:include page="/WEB-INF/fragments/header.jspf"/>
	<br>
		<h1>Strona główna</h1>
		<p>Witamy na naszej stronie głównej</p>
	<br>
	<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>

<!-- <jsp:include page="/WEB-INF/fragments/header.jspf"/>  import dynamiczny, dolacza atrybuty i parametry -->
<%-- <%@ include file="/WEB-INF/fragments/header.jspf" %> --%><!-- import statyczny, skompilowany do .java -->