<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>welcome!!!</title>
<link rel="stylesheet" href="css/normalize.css">
<link
	href='css/online.css'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/responsive.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<header>
				<img src="img/homepagelogo01.gif" alt="">
		<nav>
			<ul>
				<li><a href="index.jsp">Portfolio</a></li>
				<li><a href="index.jsp" class="selected">Sign In</a></li>
				<li><a href="aboutus.html">About Us</a></li>
			</ul>
		</nav>
	</header>

	<div id="wrapper2">

		<section>


			<form action="login_page">
				<div>
					<label for="username" class="title">Username:</label> <input
						type="text" id="username" name="username" />
				</div>
				<div>
					<label for="password" class="title">Password:</label> <input
						type="password" id="password" name="password" />
				</div>
				<div class="radio-buttons">
					<span class="title">User:</span> 
					<input type="radio" name="account" id="customer" value="customer" /> 
					<label for="customer">Customer</label>
					<input type="radio" name="account" id="admin" value="admin" /> 
					<label for="admin">Admin</label><br />
				</div>
				<div class="submit">
					<input type="submit" value="Login" id="submit" />


				</div>
				<div class="submit">
					<p>Not a member?</p>
					<a href="signup.html"> <input type="submit"
						value="Member Sign In" id="submit" />

					</a>

				</div>
			</form>






		</section>

		<footer>
			<a href="http://twitter.com"><img src="img/twitter-wrap.png"
				alt="Twitter Logo" class="social-icon"></a> <a
				href="http://facebook.com"><img src="img/facebook-wrap.png"
				alt="Facebook Logo" class="social-icon"></a>
			<p>&copy; 2014 @movies</p>
		</footer>
	</div>
</body>
</html>


