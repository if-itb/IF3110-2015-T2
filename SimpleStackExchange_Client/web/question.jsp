<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="assets/img/favicon.ico">

    <title>Simple StackExchange</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

  </head>

  <body>
      <%
        //allow access only if session exists
        String email = null;
        Boolean isLogin= false;
        if(session.getAttribute("email") != null){
           isLogin= true;
           email = (String) session.getAttribute("email");
        }
        
        String userEmail = null;
        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("email")) userEmail = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
        }else{
            sessionID = session.getId();
        }
      %>
    
      <jsp:include page="template/navbar.jsp">
        <jsp:param name="isLogin" value="<%=isLogin%>"/>
    </jsp:include>
    
    <jsp:include page="template/userinfo.jsp">
        <jsp:param name="isLogin" value="<%=isLogin%>"/>
        <jsp:param name="userEmail" value="<%=userEmail%>"/>
    </jsp:include>
      
      <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <h2>
                    <a href="${pageContext.request.contextPath}/question/?qid=1">
                    Judul Pertanyaan
                    </a>
                </h2>
                <hr>
            </div>
        </div>
           
            <div class="question-item row">
            <div class="col-sm-1 ">
                <div class="btn-group-vertical" role="group" aria-label="...">
                    <button type="button" class="btn btn-success">
                        <span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
                    </button>
                    <div class="text-center well-lg">0</div>
                    <button type="button" class="btn btn-danger">
                        <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
                    </button>
                </div>
            </div><!-- end of col-sm-1 -->
          
            <div class="col-sm-11">
            <div class="panel panel-default">
                <div class="panel-body">
                    <p>
                        Isi Pertanyaan...
                    </p>
                  <span class="pull-right">
                      <button type="button" class="btn btn-default transparent">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span> User at 2015-10-26 05:22:32
                      </button>
                      <button type="button" class="btn btn-warning " aria-label="Edit">
                        <a class="glyphicon glyphicon-pencil white" aria-hidden="true"></a>
                      </button>
                      <button type="button" class="btn btn-danger" aria-label="Delete">
                        <a class="glyphicon glyphicon-trash white" aria-hidden="true"></a>
                      </button>
                  </span>
                </div>
               
            </div>
        </div><!-- end of col-sm-11 -->
        <div class="col-sm-12">
            <h2>
                0 Answers
            </h2>
            <hr>
        </div>
        <div class="row">
            <div class="col-sm-1 col-sm-offset-1">
                <div class="btn-group-vertical" role="group" aria-label="...">
                    <button type="button" class="btn btn-success">
                        <span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
                    </button>
                    <div class="text-center well-lg">0</div>
                    <button type="button" class="btn btn-danger">
                        <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
                    </button>
                </div>
            </div><!-- end of col-sm-1 -->
            <div class="col-sm-10">
            <div class="panel panel-default">
                <div class="panel-body">
                    <p>
                        Isi Jawaban...
                    </p>
                  <span class="pull-right">
                      <button type="button" class="btn btn-default transparent">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span> User at 2015-10-26 05:22:32
                      </button>
                  </span>
                </div>
               
            </div>
        </div><!-- end of col-sm-10 -->
        </div>
      </div><!-- end of question-item -->
      
      <div class="col-sm-12">
            <h2>
                Answer Question!
            </h2>
            <hr>
        </div>
      
      <div class="row">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                  <label class="control-label col-sm-2" for="name">Name:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-sm-2" for="email">Email:</label>
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
                  </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="answer" class="pull-right">Content:</label>
                    </div>
                    <div class="col-sm-10">
                    <textarea class="form-control" rows="5" id="answer" name="answer"></textarea>
                    </div>
                  </div>
                
                <div class="form-group"> 
                  <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-info btn-block">Post</button>
                  </div>
                </div>
              </form>
      </div>
      
      <footer>
          <p class="text-center">© Simple StackExchage 2015</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

</body></html>
