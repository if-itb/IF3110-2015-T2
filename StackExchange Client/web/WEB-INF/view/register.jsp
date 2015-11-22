<%-- 
    Document   : register
    Created on : Nov 22, 2015, 6:32:31 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"/>

<div class="container">
        <h2 style="text-indent: 1em;"> Sign Up</h2>
        <hr class="heading">  
        
        <div class="inner-container">
            
                <div class="register-wrapper">
                    <form id="askForm" action="" method="POST">
                        <div class="form-field">
                            <label for="name">Name</label>
                            <input id="name-register" class="login" type="text" name="nama" placeholder="name" required autofocus>

                            <label for="email-register">Email</label>
                            <input id="email-register" class="login" type="text" name="email" placeholder="13513000@sts.stei.itb.ac.id" requiredautofocus>

                            <label for="password-regsiter">Password</label>
                            <input id="password-register" class="login" type="password" name="password" placeholder="password" required autofocus>

                            <input type="submit" id="" class="rgstr-btn" value="Sign up">
                    </form>
                </div>
        
        </div>
        
    </div>

<jsp:include page="footer.jsp" flush="true"/>
