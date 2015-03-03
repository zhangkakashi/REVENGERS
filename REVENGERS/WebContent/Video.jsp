<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>welcome!!!</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link href='../css/online.css' rel='stylesheet' type='text/css'>  
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/responsive.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>    
  <body>
    <header>
		<a id="logo"> <img src="../img/homepagelogo01.gif" alt="">
		</a>
		<nav>
			<ul>
				<s:if test="#session.customer == null">
					<jsp:forward page="index.jsp" />
				</s:if>
				<s:else>
					<li><a href="<%=basePath%>login">Sign Out</a></li>
				</s:else>
				<li><a href="../aboutus.html" class="selected">About Us</a></li>
			</ul>
		</nav>
		<form action="http://www.example.org/search.php">

			<input type="search" name="search" placeholder="Enter Keyword" /> <input
				type="submit" value="Search" />
		</form>
	</header>
    <div id="wrapper">
      <section>
        <ul id="gallery2">
          <li>
              <img src="../img/grudge.jpg" alt="">
              <p>Grudge Match</p>              
            <a href="../customer/AddVideo${video.id }?focusVideo=${video.id }"><img src="../img/addcart.jpg" class="cart" alt=""></a>            
          </li>
          <li>
							<table>
								<tr>									
									<th scope="row">Video ID</th>
									<td>${video.id }</td>
									<td></td>
                  <td></td>
								</tr>
								<tr class="even">
									<th scope="row">Title</th>
									<td colspan="3">${video.title }</td>
									           
								</tr>
								<tr>
									<th scope="row">Director</th>
									<td colspan="2">${video.director }</td>
									<td></td>
                  
								</tr>
								<tr class="even">
									<th scope="row">Cast</th>
									<td>Robert De Niro</td>
									<td>Sylvester Stallone</td>
									<td>Kim Basinger</td>									
								</tr>
								<tr>
									<th scope="row" colspan="2">Release Date</th>
								  <td colspan="3">25 December 2013 (USA)</td>
								  
								</tr>
								<tr class="even">
									<th scope="row">Format</th>
								  <td>${video.format }</td>
								  <td></td>
                  <td></td>
								</tr>
								<tr>
									<th scope="row">Runtime</th>
								  <td>${video.length }</td>
								  <td></td>
                  <td></td>
								</tr>
								<tr class="even">
									<th scope="row">Language</th>
								  <td>${video.language }</td>
								  <td></td>
                  <td></td>
								</tr>
								<tr>
									<th scope="row">MPAA</th>
								  <td>PG-13</td>
								  <td></td>
                  <td></td>
								</tr>
						
							</table>
          </li>
					<li>
						<h3>Description</h3>
						<p id="neat"><!--Henry "Razor" Sharp and Billy "The Kid" McDonnen are two boxers who thirty years ago were rivals. Just before a big match Razor decides to retire because Billy slept with his girlfriend, Sally Rose and got her pregnant. Today a promoter, Dante Slate wants to have them fight each other but Razor doesn't want to. But when he loses his job and learns he's broke, he has no choice. So he trains under his old trainer. Billy while training, meets B.J., the son he had with Sally Rose and he asks B.J. to train him. And Sally Rose tries to get Razor to forgive her but he can't. Written by rcs0411@yahoo.com-->
						${video.description }
						</p>
					</li>
        </ul>
        
      </section>
      <footer>
        <a href="http://twitter.com"><img src="../img/twitter-wrap.png" alt="Twitter Logo" class="social-icon"></a>
        <a href="http://facebook.com"><img src="../img/facebook-wrap.png" alt="Facebook Logo" class="social-icon"></a>
        <p>&copy;  2014 @movies.</p>
      </footer>
    </div>
  </body>
</html>