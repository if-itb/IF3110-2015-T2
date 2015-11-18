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
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Stack Exchange</title>
    </head>
    <body>
	
	<div class="container">
            <h1>Simple StackExchange</h1><br>
            <h2>The question topic goes here</h2><br>    
            <table>
		<tr>
                    <td style="width:15%; text-align:center">
                        <img src="images/up.png"><br>
                        <p id="vote" style="font-size:40px; margin:0; color:lightgrey"> 0 </p>
                        <img src="images/down.png">
		    </td>
		    <td style="vertical-align:top">
		    	Content<br>
		    </td>
		</tr>
            </table>
            <p style="text-align:right">asked by username at date | edit | delete</p>
            <h2>1 Answer</h2><br>    
                
            <table>
		<tr style="border-bottom:2px solid #000">
                    <td style="width:15%; text-align:center; padding:20px">
                        <img src="images/up.png"><br>
			<p style="font-size:40px; margin:0; color:lightgrey">1</p>
			<img src="images/down.png">
                    </td>
                    <td style="vertical-align:top; padding:20px">Content<br>
			<p style="text-align:right">answered by username at date</p>
                    </td>
		</tr>
            </table>
            
            <br><p style="font-size:30px; margin:0; color:grey"> Your Answer </p>
            <form name="AnswerForm" action="AddAnswer.php" onsubmit="return validateAnswerForm()" method="POST">
		<input type="text" name="name" id="inputtext1" placeholder="Name"><br>
		<input type="text" name="email" id="inputtext1" placeholder="Email"><br>
		<textarea name="content" id="content" placeholder="Content"></textarea><br><br>
		<input type="submit" value="Post">
            </form>
            
	</div>	
    </body>
</html>
