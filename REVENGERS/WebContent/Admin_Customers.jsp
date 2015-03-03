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
<title>Admin_Customers</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/normalize.css">
<link href='${pageContext.request.contextPath }/css/online.css'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/responsive.css">
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	function toEdit(n) {

		document.getElementById(n + 'username').disabled = false;
		document.getElementById(n + 'password').disabled = false;
		document.getElementById(n + 'name').disabled = false;
		document.getElementById(n + 'age').disabled = false;
		document.getElementById(n + 'gender').disabled = false;
		document.getElementById(n + 'address').disabled = false;
		document.getElementById(n + 'phone').disabled = false;
		document.getElementById(n + 'email').disabled = false;
		document.getElementById(n + 'credit_card').disabled = false;
		document.getElementById(n + 'priority').disabled = false;

		document.getElementById(n + 'button').value = "submit";

		document.getElementById(n + 'button').onclick = function() {
			var username = document.getElementById(n + 'username').value;
			var password = document.getElementById(n + 'password').value;
			var name = document.getElementById(n + 'name').value;
			var age = document.getElementById(n + 'age').value;
			var gender = document.getElementById(n + 'gender').value;
			var address = document.getElementById(n + 'address').value;
			var phone = document.getElementById(n + 'phone').value;
			var email = document.getElementById(n + 'email').value;
			var credit_card = document.getElementById(n + 'credit_card').value;
			var priority = document.getElementById(n + 'priority').value;
			var id = document.getElementById(n + 'id').value;

			$.get("admin/AdminCustomersEdit?username=" + username
					+ "&password=" + password + "&name=" + name + "&age=" + age
					+ "&gender=" + gender + "&address=" + address + "&phone="
					+ phone + "&email=" + email + "&credit_card=" + credit_card
					+ "&priority=" + priority + "&id=" + id, null, null);

			document.getElementById(n + 'username').disabled = true;
			document.getElementById(n + 'password').disabled = true;
			document.getElementById(n + 'name').disabled = true;
			document.getElementById(n + 'age').disabled = true;
			document.getElementById(n + 'gender').disabled = true;
			document.getElementById(n + 'address').disabled = true;
			document.getElementById(n + 'phone').disabled = true;
			document.getElementById(n + 'email').disabled = true;
			document.getElementById(n + 'credit_card').disabled = true;
			document.getElementById(n + 'priority').disabled = true;

			document.getElementById(n + 'button').value = "edit";
			document.getElementById(n + 'button').onclick = function() {
				toEdit(n);
				return false
			}
		};
	}
</script>

</head>
<body>
	<header>
		<a id="logo"> <img
			src="${pageContext.request.contextPath }/img/homepagelogo01.gif"
			alt="">
		</a>
		<nav>
			<ul>
				<s:if test="#session.admin == null">
					<jsp:forward page="index.jsp" />
				</s:if>
				<s:else>
					<li><a href="<%=basePath%>login">Sign Out</a></li>
				</s:else>
				<li><a href="${pageContext.request.contextPath }/aboutus.html"
					class="selected">About Us</a></li>
			</ul>
		</nav>
		<form action="http://www.example.org/search.php">

			<input type="search" name="search" placeholder="Enter Keyword" /> <input
				type="submit" value="Search" />
		</form>
	</header>
	<s:iterator value="customers" var="c" status="status">
		<s:set value="#c.id" var="N" />

		<s:property value="#N" />	|	
		<s:hidden id="%{#N }id" name="id" value="%{#N}"></s:hidden>

		<s:textfield id="%{#N }username" name="username"
			value="%{#c.username}" disabled="true" />
		<s:textfield id="%{#N }password" name="password"
			value="type new password here" disabled="true" />
		<s:textfield id="%{#N }gender" name="gender" value="%{#c.gender}"
			disabled="true" />
		<s:textfield id="%{#N }name" name="name" value="%{#c.name}"
			disabled="true" />
		<s:textfield id="%{#N }age" name="age" value="%{#c.age}"
			disabled="true" />
		<s:textfield id="%{#N }address" name="address" value="%{#c.address}"
			disabled="true" />
		<s:textfield id="%{#N }phone" name="phone" value="%{#c.phone}"
			disabled="true" />
		<s:textfield id="%{#N }email" name="email" value="%{#c.email}"
			disabled="true" />
		<s:textfield id="%{#N }credit_card" name="credit_card"
			value="%{#c.credit_card}" disabled="true" />
		<s:textfield id="%{#N }priority" name="priority"
			value="%{#c.priority}" disabled="true" />

		<s:submit id="%{#N }button" value="edit"
			onclick="toEdit('%{#N }');return false"></s:submit>



		<br>
	</s:iterator>
	<a href="<%=basePath%>login_again">Home Page</a>
	<s:debug></s:debug>
	<footer>
		<a href="http://twitter.com"><img
			src="${pageContext.request.contextPath }/img/twitter-wrap.png"
			alt="Twitter Logo" class="social-icon"></a> <a
			href="http://facebook.com"><img
			src="${pageContext.request.contextPath }/img/facebook-wrap.png"
			alt="Facebook Logo" class="social-icon"></a>
		<p>&copy; 2014 @movies</p>
	</footer>

</body>
</html>