<%-- 
    Document   : login
    Created on : Nov 18, 2015, 12:04:59 PM
    Author     : visat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"/>
    <div class="container">
        <h2>Login</h2>
        <hr class="heading">
        <form action="" method="post">            
            <input type="email" name="email" placeholder="Email" required autofocus"></input>
            <input type="password" name="password" placeholder="Password" required"></input>            
            <input type="submit" class="btn-default btn-right" value="Login"></input>            
        </form>
    </div>
<jsp:include page="footer.jsp" flush="true"/>