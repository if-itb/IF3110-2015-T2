<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Simple StackExchange</title>

    <!-- Main style -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Google fonts -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:800italic,300,400,400italic,600,700' rel='stylesheet' type='text/css'>
</head>
<body>

<div class="outer-container">
    
    <header class="main-title">
        <h1>Stack<span>Exchange<span></h1>
    </header>

    <div class="inner-container">

        <div class="row">
            <div class="col-12">

                <div class="register-form-wrapper">
                    <form id="askForm" action="" method="POST">
                        <div class="form-field">
                            <label for="name">Name</label>
                            <input id="name-register" class="login" type="text" placeholder="name" required>
                        </div>

                        <div class="form-field">
                            <label for="email-register">Email</label>
                            <input id="email-register" class="login" type="text" placeholder="email@something.com" required>
                        </div>

                        <div class="form-field">
                            <label for="password-regsiter">Password</label>
                            <input id="password-register" class="login" type="password" placeholder="password" required>
                        </div>
                        <input type="submit" id="" class="btn-submit" value="Sign up">
                    </form>
                </div>
                
            </div> <!-- .col -->
        </div> <!-- .row -->
        
    </div> <!-- .inner-container -->

</div> <!-- .outer-container -->
<script src="js/app.js"></script>

</body>
</html>

