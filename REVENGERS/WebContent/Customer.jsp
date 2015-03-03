<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/normalize.css">
<link href='${pageContext.request.contextPath }/css/online.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/responsive.css">
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>

</head>
<body>

	<header>
		<a id="logo"> <img src="${pageContext.request.contextPath }/img/homepagelogo01.gif" alt="">
		</a>
		<nav>
			<ul>
				<s:if test="#session.customer == null">
					<jsp:forward page="login" />
				</s:if>
				<s:else>
					<li><a href="<%=basePath%>login">Sign Out</a></li>
				</s:else>
				<li><a href="${pageContext.request.contextPath }/aboutus.html" class="selected">About Us</a></li>
			</ul>
		</nav>
		<form action="http://www.example.org/search.php">

			<input type="search" name="search" placeholder="Enter Keyword" /> <input
				type="submit" value="Search" />
		</form>
	</header>


	<div id="wrapper2">
		<section>


			Welcome Customer <s:property value="#session.customer.name" />
			<s:property value="#session.username" />
			!<br>
			<s:property value="#session.customer.gender" />
			&nbsp;&nbsp;|&nbsp;&nbsp;
			<s:property value="#session.customer.username" />
			&nbsp;&nbsp;|
			<s:property value="#session.customer.address" />&nbsp;&nbsp;
			<br> <a href="customer/Customer_Edit">Edit Information</a><br>
			<a href="customer/Shopping_Cart">Go to Shopping Cart"
            </a><br> 
			<s:iterator value="#session.videos" var="c" status="status">
			   <s:a href="video/view?videoId=%{#c.id}"><s:property value="#c.title"/>&nbsp;&nbsp;&nbsp;&nbsp;</s:a>
			</s:iterator>
			<a href="login">Logout Dude!</a>
				
				
			

			<s:debug></s:debug>
		</section>
	</div>
	<footer>
		<a href="http://twitter.com"><img src="${pageContext.request.contextPath }/img/twitter-wrap.png"
			alt="Twitter Logo" class="social-icon"></a> <a
			href="http://facebook.com"><img src="${pageContext.request.contextPath }/img/facebook-wrap.png"
			alt="Facebook Logo" class="social-icon"></a>
		<p>&copy; 2014 @movies</p>
	</footer>





</body>
</html>