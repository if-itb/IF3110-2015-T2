<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Stack Overchange</title>
    </head>
    <body>
        <div class="login-form">
                     <div class="login">
                        <h1>Login</h1>
                        <form method="post" action="">
                            <p><input type="text" name="login" value="" placeholder="Username or Email"></p>
                            <p><input type="password" name="password" value="" placeholder="Password"></p>
                            <p class="remember_me">
                            <label>
                                <label>
                                <input type="checkbox" name="remember_me" id="remember_me">
                                    Remember me on this computer
                                </label>
                            </label>
                            </p>
                            <p class="submit"><input type="submit" name="commit" value="Login"></p>
                        </form>
                    </div>
 
                    <div class="login-help">
                        <p>Forgot your password? <a href="#">Click here to reset it</a>.</p>
                    </div>
         </div>
        <div class="container">
            <!-- HEADER -->
            <header>
                
            </header>
            <!-- End of HEADER>

            <!-- MAIN -->
            <div class="">
                <h1>Simple StackExchange</h1>
		<form class="search-box" action="<?php echo $_SERVER['PHP_SELF']; ?>"  method="post" >
			<input  type="text" name="searchbox">
			<input  type="submit" name="submit" value="Search">
		</form>
		<div class="center" >
		Canot find what you are looking for? <a id="y" href="AskHere.php">Ask here</a>
		</div>
                </div>

                <div class="">
                    <h1>Recently</h1>
                    <hr>
                </div>

                <div class="">
                    <!-- POST LIST -->
                    <div class="">
                        <div class="">
                            <div class="">
                                <h3>0</h3>
                                <h3>Votes</h3>
                            </div>
                            <div class="">
                                <h3>0</h3>
                                <h3>Answers</h3>
                            </div>
                        </div>

                        <div class="">
                            <h4><a href="">Topic</a></h4>
                            <p>Post Text</p>
                        </div>

                        <div class="">
                            <p>
                                asked by <span class="" >Author</span> | 
                                <a href="">edit</a> | 
                                <a class="" href="" onclick="">delete</a>
                            </p>
                        </div>	
                    </div>
                    <!-- End of POST LIST-->
                </div>
            </div>
            <!-- End of MAIN>

            <!-- FOOTER -->
            <footer>
                <em>FIDI-R 2015</em>
            </footer>
            <!-- End of FOOTER -->
        </div>
    </body>
</html>
