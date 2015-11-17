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
            <form class="form-horizontal" action="${pageContext.request.contextPath}/search" method="GET">
            <div class="col-lg-12">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="Search for...">
                  <span class="input-group-btn">
                    <button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                  </span>
                </div><!-- /input-group -->
            </div><!-- /.col-lg-12 -->
          </form>
            
        </div>
            
        <div class="row">
            <div class="col-sm-12">
                <h2>
                    Recently Asked Questions
                </h2>
                <hr>
            </div>
          </div>
           
            <div class="question-item row">
            <div class="col-sm-1 ">
                <div class="text-center well-lg text-lg">0</div>
                <div class="text-center">votes</div>
            </div><!-- end of col-sm-1 -->
            <div class="col-sm-1 ">
                <div class="text-center well-lg text-lg">0</div>
                <div class="text-center">answers</div>
            </div><!-- end of col-sm-1 -->
            <div class="col-sm-10">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><h4><a href="${pageContext.request.contextPath}/question/?qid=1">Judul Pertanyaan</a></h4></div>
                <div class="panel-body">
                  
                  <span class="pull-right">
                      <button type="button" class="btn btn-default transparent">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span> User
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
       
      </div><!-- end of question-item -->
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
