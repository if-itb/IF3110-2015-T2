<%-- 
    Document   : login
    Created on : Nov 18, 2015, 12:04:59 PM
    Author     : visat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"/>
    <div class="container">
        <h2 style="text-indent: 1em;">Login</h2>
        <hr class="heading">  
        
        <div class="inner-container">

                <div class="login-wrapper">
                    <form id="askForm" action="" method="POST">
                        <div class="form-field">
                            <label for="email">Email</label>
                            <input name="email" id="email-login" class="login" type="text" placeholder="13513000@std.stei.itb.ac.id" required autofocus>
                        </div>

                        <div class="form-field">
                            <label for="password">Password</label>
                            <input name="password" id="password-login" class="login" type="password" placeholder="password" required>
                        </div>
                        
                        <input type="submit" class="login-btn" value="Login"></input>   
                       
                    </form>
                </div>
        
        </div>
        
    </div>

<jsp:include page="footer.jsp" flush="true"/>