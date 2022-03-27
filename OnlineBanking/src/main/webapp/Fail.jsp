<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
     body
     {
       color : red;
     }
</style>
</head>
<body>
<%
String msg = (String)request.getAttribute("msg");
out.println(msg);
%>
<jsp:include page="home.html"></jsp:include>
</body>
</html>