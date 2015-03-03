<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:property value="#session.customer.username"/>

<table border=2px>
<form name="DBform" method="post">
	<tr><th>check</th><th>id</th><th>username</th><th>gender</th><th>name</th><th>age</th><th>address</th><th>phone</th><th>email</th><th>credit card</th><th>priority</th></tr>
		<s:iterator value="#session.displayCU" status="userStatus">
		<tr>
			<td><input type="checkbox" value=<s:property value="id" /> name="vdel"></td>
			<td> <s:property value="id" /></td>
			<td><s:property value="username"/></td>
		<!--  	<td><s:property value="password"/></td>	-->
			<td><s:property value="gender"/></td>
			<td><s:property value="name"/></td>
			<td><s:property value="age"/></td>
			<td><s:property value="address"/></td>
			<td><s:property value="phone"/></td>
			<td><s:property value="email"/></td>
			<td><s:property value="credit_card"/></td>
			<td><s:property value="priority"/></td>
			<td><a href="editCus?id=<s:property value="id" />">edit</a></td>
		</tr>
		</s:iterator>	
</table>
<input type="button" value="delete" onclick="deleteRecord()"> 
<s:debug></s:debug>
</body>
</html>