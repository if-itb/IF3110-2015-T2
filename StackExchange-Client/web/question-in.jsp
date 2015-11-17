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
					<a href="#"><h4>Hi, <span>Fauzan</span></h4></a>
				</div>
				<div class="nav-menu askhere">
					<a href="#"><h4>Ask Here</h4></a>
				</div>
			</nav>
			<div>
				<a href="index.jsp"><h1 class="brand">Stack<span>Exchange</span></h1></a>
			</div>
		</div>
	</div>
	<div class="inner">

		<h1 class="tag">Question Topic</h1>
		<div class="innerContent fQuestion">
			<div class="col votesCount">
				<div class="up vote" id="upQuestion{{id}}">
					<i class="material-icons md-48">arrow_drop_up</i>
				</div>
				<div id="questionVote{{id}}">
					1
				</div>
				<div class="down vote" id="downQuestion{{id}}">
					<i class="material-icons md-48">arrow_drop_down</i>
				</div>
			</div>
			<div class="col content">
				<p>
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
				</p>
			</div>
			<div class="navPost2">
				<p>
					asked by Fauzan <span>fauzan@gmail.com</span> at 3/11/2015 | <a class="link edit" href="askhere.jsp?id={{id}}"> edit</a> | <a class="link delete" href="index.jsp?delete=true&id={{id}}" onclick="return validateDelete();"> delete </a>
				</p>
			</div>
		</div>
		<div class="containerAnswer">
			<h1 class="tag">4 Answer</h1>
			<div id="answer{{id}}" class="innerContent fAnswer">
				<div class="col votesCount">
					<div class="up vote" id="upAnswer{{id}}">
						<i class="material-icons md-48">arrow_drop_up</i>
					</div>
					<div id="answerVote{{id}}">
						2
					</div>
					<div class="down vote" id="downAnswer{{id}}">
						<i class="material-icons md-48">arrow_drop_down</i>
					</div>
				</div>
				<div class="col content">
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
						proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
					</p>
				</div>
				<div class="navPost2">
					<p>
						answered by Wawan <span>wawan@gmail.com</span> at 4/11/2015
					</p>
				</div>
			</div>
			<div id="answer{{id}}" class="innerContent fAnswer">
				<div class="col votesCount">
					<div class="up vote" id="upAnswer{{id}}">
						<i class="material-icons md-48">arrow_drop_up</i>
					</div>
					<div id="answerVote{{id}}">
						2
					</div>
					<div class="down vote" id="downAnswer{{id}}">
						<i class="material-icons md-48">arrow_drop_down</i>
					</div>
				</div>
				<div class="col content">
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
						proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
					</p>
				</div>
				<div class="navPost2">
					<p>
						answered by Wawan <span>wawan@gmail.com</span> at 4/11/2015
					</p>
				</div>
			</div>
			<div id="answer{{id}}" class="innerContent fAnswer">
				<div class="col votesCount">
					<div class="up vote" id="upAnswer{{id}}">
						<i class="material-icons md-48">arrow_drop_up</i>
					</div>
					<div id="answerVote{{id}}">
						2
					</div>
					<div class="down vote" id="downAnswer{{id}}">
						<i class="material-icons md-48">arrow_drop_down</i>
					</div>
				</div>
				<div class="col content">
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
						proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
					</p>
				</div>
				<div class="navPost2">
					<p>
						answered by Wawan <span>wawan@gmail.com</span> at 4/11/2015
					</p>
				</div>
			</div>
			<div id="answer{{id}}" class="innerContent fAnswer">
				<div class="col votesCount">
					<div class="up vote" id="upAnswer{{id}}">
						<i class="material-icons md-48">arrow_drop_up</i>
					</div>
					<div id="answerVote{{id}}">
						2
					</div>
					<div class="down vote" id="downAnswer{{id}}">
						<i class="material-icons md-48">arrow_drop_down</i>
					</div>
				</div>
				<div class="col content">
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
						proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
					</p>
				</div>
				<div class="navPost2">
					<p>
						answered by Wawan <span>wawan@gmail.com</span> at 4/11/2015
					</p>
				</div>
			</div>
		</div>

		<div id="answerForm">
			<h1 class="tag">Your Answer</h1>
			<form onsubmit="return validasi(this);" class="form makeQuestion" method="POST" action="Answer">
				<div class="innerForm">
					<textarea class="textArea" name="content" placeholder="Insert your answer here..."></textarea>
				</div>
				<div class="innerForm">
					<input class="submitButton" type="submit" value="Send Answer">
				</div>
			</form>
		</div>

	</div>
	<div class="footer">
	
	</div>
	<script src="js/function.js"></script>
	</body>
</html>