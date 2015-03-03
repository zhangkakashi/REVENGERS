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
<title>Admin_Transactions</title>
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

		document.getElementById(n + 'rent_date').disabled = false;
		document.getElementById(n + 'due_date').disabled = false;
		document.getElementById(n + 'return_date').disabled = false;
		document.getElementById(n + 'customer_id').disabled = false;
		document.getElementById(n + 'video_id').disabled = false;
		document.getElementById(n + 'admin_id').disabled = false;

		document.getElementById(n + 'button').value = "submit";

		document.getElementById(n + 'button').onclick = function() {
			var rent_date = document.getElementById(n + 'rent_date').value;
			var due_date = document.getElementById(n + 'due_date').value;
			var return_date = document.getElementById(n + 'return_date').value;
			var customer_id = document.getElementById(n + 'customer_id').value;
			var video_id = document.getElementById(n + 'video_id').value;
			var admin_id = document.getElementById(n + 'admin_id').value;
			var id = document.getElementById(n + 'id').value;

			$.get("admin/AdminTransactionsEdit?id=" + id + "&rent_date="
					+ rent_date + "&due_date=" + due_date + "&return_date="
					+ return_date + "&customer_id=" + customer_id
					+ "&video_id=" + video_id + "&admin_id=" + admin_id, null,
					null);

			document.getElementById(n + 'rent_date').disabled = true;
			document.getElementById(n + 'due_date').disabled = true;
			document.getElementById(n + 'return_date').disabled = true;
			document.getElementById(n + 'customer_id').disabled = true;
			document.getElementById(n + 'video_id').disabled = true;
			document.getElementById(n + 'admin_id').disabled = true;

			document.getElementById(n + 'button').value = "edit";
			document.getElementById(n + 'button').onclick = function() {
				toEdit(n);
				return false;
			};
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
					<jsp:forward page="${pageContext.request.contextPath }/index.jsp" />
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
	<s:iterator value="transactions" var="c" status="status">
		<s:set value="#c.id" var="N" />

		<s:property value="#N" />	|	
		<s:hidden id="%{#N }id" name="id" value="%{#N}"></s:hidden>

		<s:textfield id="%{#N }rent_date" name="rent_date"
			value="%{#c.rent_date}" disabled="true" />
		<s:textfield id="%{#N }due_date" name="due_date"
			value="%{#c.due_date}" disabled="true" />
		<s:textfield id="%{#N }return_date" name="return_date"
			value="%{#c.return_date}" disabled="true" />
		<s:textfield id="%{#N }customer_id" name="customer_id"
			value="%{#c.customer.id}" disabled="true" />
		<s:textfield id="%{#N }video_id" name="video_id"
			value="%{#c.video.id}" disabled="true" />
		<s:textfield id="%{#N }admin_id" name="admin_id"
			value="%{#c.admin_id}" disabled="true" />

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