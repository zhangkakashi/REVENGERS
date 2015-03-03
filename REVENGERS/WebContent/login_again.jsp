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
	<s:if test="#session.customer != null">
		<jsp:forward page="Customer.jsp"/>
	</s:if>
	<s:elseif test="#session.admin != null">
		<jsp:forward page="Admin.jsp"/>
	</s:elseif>
	<s:else>
		<jsp:forward page="${pageContext.request.contextPath }/index.jsp"></jsp:forward>
	</s:else>
	
</body>
</html>



