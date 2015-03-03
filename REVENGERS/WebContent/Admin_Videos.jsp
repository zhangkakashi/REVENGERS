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
<title>Admin Change Video</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/normalize.css">
<link href='${pageContext.request.contextPath }/css/online.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/responsive.css">
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	function toEdit(n) {

		document.getElementById(n + 'title').disabled = false;
		document.getElementById(n + 'director').disabled = false;
		document.getElementById(n + 'actor').disabled = false;
		document.getElementById(n + 'year').disabled = false;
		document.getElementById(n + 'stock').disabled = false;
		document.getElementById(n + 'address').disabled = false;
		document.getElementById(n + 'length').disabled = false;
		document.getElementById(n + 'description').disabled = false;
		document.getElementById(n + 'language').disabled = false;
		document.getElementById(n + 'priority').disabled = false;
		document.getElementById(n + 'category').disabled = false;
		document.getElementById(n + 'format').disabled = false;

		document.getElementById(n + 'button').value = "submit";

		document.getElementById(n + 'button').onclick = function() {
			var title = document.getElementById(n + 'title').value;
			var director = document.getElementById(n + 'director').value;
			var actor = document.getElementById(n + 'actor').value;
			var year = document.getElementById(n + 'year').value;
			var stock = document.getElementById(n + 'stock').value;
			var address = document.getElementById(n + 'address').value;
			var length = document.getElementById(n + 'length').value;
			var description = document.getElementById(n + 'description').value;
			var language = document.getElementById(n + 'language').value;
			var priority = document.getElementById(n + 'priority').value;
			var category = document.getElementById(n + 'category').value;
			var format = document.getElementById(n + 'format').value;
			var id = document.getElementById(n + 'id').value;

			$
					.get("admin/AdminVideosEdit?id=" + id + "&title=" + title
							+ "&director=" + director + "&actor=" + actor
							+ "&year=" + year + "&stock=" + stock + "&address="
							+ address + "&length=" + length + "&description="
							+ description + "&language=" + language
							+ "&priority=" + priority + "&category=" + category
							+ "&format=" + format, null, null);

			document.getElementById(n + 'title').disabled = true;
			document.getElementById(n + 'director').disabled = true;
			document.getElementById(n + 'actor').disabled = true;
			document.getElementById(n + 'year').disabled = true;
			document.getElementById(n + 'stock').disabled = true;
			document.getElementById(n + 'address').disabled = true;
			document.getElementById(n + 'length').disabled = true;
			document.getElementById(n + 'description').disabled = true;
			document.getElementById(n + 'language').disabled = true;
			document.getElementById(n + 'priority').disabled = true;
			document.getElementById(n + 'category').disabled = true;
			document.getElementById(n + 'format').disabled = true;

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
     <a id="logo">
      <img src ="${pageContext.request.contextPath }/img/homepagelogo01.gif" alt="">
      </a>
      <nav>
        <ul>
          <s:if test="#session.admin == null">
		     <jsp:forward page="index.jsp" />
	      </s:if>
	      <s:else>
            <li><a href="<%=basePath%>login">Sign Out</a></li>
	      </s:else>
          <li><a href="${pageContext.request.contextPath }/aboutus.html" class="selected">About Us</a></li>
        </ul>
      </nav>
        <form action="http://www.example.org/search.php">
           
            <input type="search" name="search"
              placeholder="Enter Keyword"/>
            <input type="submit" value="Search"/>
            </form>       
    </header>
    


		<section>


			<table border="2">
		<tr>
			<th>id</th>
			<th>title</th>
			<th>director</th>
			<th>actor</th>
			<th>year</th>
			<th>stock</th>
			<th>length</th>
			<th>description</th>
			<th>language</th>
			<th>category</th>
			<th>format</th>
			<th>address</th>
			<th>priority</th>
			<th></th>
		</tr>

		<s:iterator value="videos" var="c" status="status">
			<s:set value="#c.id" var="N" />
			<tr>
				<td><s:property value="%{#N}" /></td>
				<s:hidden id="%{#N }id" name="id" value="%{#N}"></s:hidden>
				<td><s:textfield id="%{#N }title" name="title"
						value="%{#c.title}" disabled="true" size="10" /></td>
				<td><s:textfield id="%{#N }director" name="director"
						value="%{#c.director}" disabled="true" size="10" /></td>
				<td><s:textfield id="%{#N }actor" name="actor"
						value="%{#c.actor}" disabled="true" size="10" /></td>
				<td><s:textfield id="%{#N }year" name="year" value="%{#c.year}"
						disabled="true" size="2" /></td>
				<td><s:textfield id="%{#N }stock" name="stock"
						value="%{#c.stock}" disabled="true" size="1" /></td>
				<td><s:textfield id="%{#N }length" name="length"
						value="%{#c.length}" disabled="true" size="5" /></td>
				<td><s:textfield id="%{#N }description" name="description"
						value="%{#c.description}" disabled="true" /></td>
				<td><s:textfield id="%{#N }language" name="language"
						value="%{#c.language}" disabled="true" size="10" /></td>
				<td><s:textfield id="%{#N }category" name="category"
						value="%{#c.category}" disabled="true" size="10" /></td>
				<td><s:textfield id="%{#N }format" name="format"
						value="%{#c.format}" disabled="true" size="5" /></td>
				<td><s:textfield id="%{#N }address" name="address"
						value="%{#c.address}" disabled="true" size="10"/></td>
				<td><s:textfield id="%{#N }priority" name="priority"
						value="%{#c.priority}" disabled="true" size="2" /></td>
				<td><s:submit id="%{#N }button" value="edit"
						onclick="toEdit('%{#N }');return false"></s:submit><br /></td>

			</tr>
		</s:iterator>
	</table>



	<br>
	
	<a href="<%=basePath%>login_again">Home Page</a>

	<a href="<%=basePath%>login">Logout Dude!</a>

	<s:debug></s:debug>





		</section>

		<footer>
			<a href="http://twitter.com"><img src="${pageContext.request.contextPath }/img/twitter-wrap.png"
				alt="Twitter Logo" class="social-icon"></a> <a
				href="http://facebook.com"><img src="${pageContext.request.contextPath }/img/facebook-wrap.png"
				alt="Facebook Logo" class="social-icon"></a>
			<p>&copy; 2014 @movies</p>
		</footer>




	
</body>
</html>