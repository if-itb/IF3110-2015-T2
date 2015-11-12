<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <title>Simple StackExchange</title>
    </head>

    <body>
        <div class="link-normalizer"><a class='title' href="question.php">Simple StackExchange</a></div>

        <br><br><br><br>

        <form name='searchForm' action='search.php' method='post'>
            <input class='form-search' type="text" name="search_key" size='120%'>
            <button class='button-search' type='submit'> Search </button>
        </form>

        <div class="smalltitle-center">Cannot find what you are looking for? <a id = "color-orange" href="ask.php" >Ask here</a></div>
        <br>

        <div class="smalltitle-left"> Recently Asked Questions </div>

        <hr class='line'>
    </body>
</html>