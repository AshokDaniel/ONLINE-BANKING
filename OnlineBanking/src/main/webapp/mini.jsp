<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body style="text-align:center">
<%

String fname = (String)session.getAttribute("fname");
Connection con = DBConnection.getCon();
PreparedStatement psa = con.prepareStatement("select * from UserReg where fname =? ");
psa.setString(1, fname);
ResultSet rsa = psa.executeQuery();
long accno = 0;
if(rsa.next())
{
	accno = rsa.getLong(9);	
}
PreparedStatement ps = con.prepareStatement("select * from Deposit where accno =? ");
ps.setLong(1, accno);
ResultSet rs = ps.executeQuery();
PreparedStatement ps2 = con.prepareStatement("select * from WithDraw where accno=?");
ps2.setLong(1, accno);
ResultSet rs2 = ps2.executeQuery();
%>
<table border="1">
    <tr>
	<th>Customer AccNo</th>
	<th>Deposit/WithDraw</th>
	<th>Date of Transaction</th>
	</tr>
	<%
while(rs.next())
{%>
    
	<tr>
	<td><%=rs.getLong(1) %></td>
	<td><%=rs.getString(2)%></td>
	<td><%=rs.getDate(3)%></td>
	</tr>
	
	<%
}
	while(rs2.next())
	{%>
	    
		<tr>
		<td><%=rs2.getLong(1) %></td>
		<td><%=rs2.getString(2)%></td>
		<td><%=rs2.getDate(3)%></td>
		</tr>
		
		<%
	}
%>	
</table>
</body>
</html>