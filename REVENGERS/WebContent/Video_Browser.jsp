<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:property value="#session.customer.username"/>
<s:iterator value="#session.videos" id="videos">
	<s:property value="#videos.title"/><br>
</s:iterator>


<form action="customer/Shopping_Cart">
	<s:checkboxlist name="chosenVideos" list="#session.videos" listKey="id" listValue="title" value="#session.videos.id"></s:checkboxlist>
	<input type="submit" value="Go to Shopping Cart" />
</form>
<s:debug></s:debug>
</body>
</html>