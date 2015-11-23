<%-- 
    Document   : login
    Created on : Nov 18, 2015, 12:04:59 PM
    Author     : visat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"/>
    <div class="container">
        <h3>Sign in</h3>
        <hr class="heading">  
        
        <div class="inner-container">

            <form class="login-wrapper form-horizontal" method="POST">
                <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
        
        </div>
        
    </div>

<jsp:include page="footer.jsp" flush="true"/>