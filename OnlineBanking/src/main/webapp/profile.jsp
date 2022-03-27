<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
    body
    {
      text-align : center;
      background-color :violet;
    }
    h3
    {
       background-color : blue;
       border : 2px solid red;
    }
</style>
</head>
<body>
<h3>User Details</h3>
<h4>
<%
UserBean ub = (UserBean)session.getAttribute("ubean");
out.println("Account Number :"+ub.getAccNo()+"<br><br>");
out.println("First Name : "+ub.getfName()+"<br><br>");
out.println("Last Name :"+ub.getlName()+"<br><br>");
out.println("Mail Id :"+ub.getmId()+"<br><br>");
out.println("Phone Number : "+ub.getPhNo()+"<br><br>");
out.println("Balance :"+ub.getBal()+"<br><br>");
out.println("Type of account  :"+ub.getToA()+"<br><br>");
%>
</h4>
</body>
</html>