<%-- 
    Document   : viewpost
    Created on : Nov 10, 2015, 3:57:58 PM
    Author     : FiqieUlya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="kotak">
            <img class='arrow' href='#' src='triangle-up.png' onclick='voteQuestion($id_Question,0)' >
		<br><br><span id='question-". $id_Question ."'>" . $row["Vote"] ."</span><br><br>	
                    <img class='arrow' id='down' href='#' src='triangle-up.png' onclick='voteQuestion($id_Question,1)'   >
	</div>
	<div class= "question-box">
            <div class= "resQuestion">
		Question
            </div>
            <div class= "infoQuestion">																										
		asked by xxxx at 00-00-00 <a href='AskHere.php?id=".$id_Question."' id='y'> edit </a> |<a id='r'  href='javascript:deletePost(\"delete_question.php?id=$id_Question\")'>delete</a>|
            </div>
	</div>
	
	<div class="container">
            <h1>Simple StackExchange</h1>
		<br><br><br>
            <div class="box1">
		<div class="SubTitle">
                    <h2>The question topic goes here </h2>
		</div>
		<div class="content" id="q" >
                    <?php readQuestion( $_GET["id"]);?>
		</div>
            </div>
            <div class="box2">	
		<?php readAnswer($_GET["id"]);?>				
            </div>
            <div class="answerform">
		Your Answer
		<form name="myForm" onsubmit="return validateForm()" action="add_answer.php" method="post">
                    <input type="text" name="Name" placeholder="Name" >
                    <input type="text" id="email" name="Email" placeholder="Email">
                    <input type="hidden" name ="id-question" value="<?php echo $_GET["id"];?>">
                    <textarea placeholder= "Content" name="message"  ></textarea>
                    <input class="button" type="submit" name="Post" value="Post">
		</form>
            </div>
	</div>	
    </body>
</html>
