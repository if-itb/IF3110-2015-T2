<html>
	<head>
		<title>StackExchange</title>

		<link href="css/style.css" rel="stylesheet">
		<!-- Link berikut hanya merupakan import library icon -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

	</head>
	<body>
	<div class="container-brand">
		<div class="container-br-in">
			<a href="../">
				<div class="menu hvr-radial-out">
					<i class="material-icons md-18">menu</i>
				</div>
			</a>
			<nav class="ut-nav">
				<div class="nav-menu">
					<a href="#"><h4><span>Sign In</span></h4></a>
				</div>
				<div class="nav-menu askhere">
					<a href="#"><h4>Sign Up</h4></a>
				</div>
			</nav>
			<div>
				<a href="index.jsp"><h1 class="brand">Stack<span>Exchange</span></h1></a>
			</div>
		</div>
	</div>
	<div class="inner">

		<h1 class="tag">Sign Up</h1>

		<form onsubmit="return validasi(this);" class="form makeQuestion" method="post" action="register">
			<div class="innerForm">
				<input class="textForm" type="text" placeholder="Name" name="name">
			</div>
			<div class="innerForm">
				<input class="textForm" type="email" placeholder="Email" name="email">
			</div>
			<div class="innerForm">
				<input class="textForm" type="password" placeholder="Password" name="email">
			</div>
			<div class="innerForm">
				<input class="submitButton" type="submit" placeholder="Sign Up" value="Sign Up">
			</div>
		</form>

	</div>
	<div class="footer">
	
	</div>
	<script src="js/function.js"></script>
	</body>
</html>