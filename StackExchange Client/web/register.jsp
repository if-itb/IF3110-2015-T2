<%-- 
    Document   : register
    Created on : Nov 17, 2015, 12:47:14 PM
    Author     : jessica
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/views/header.jsp" flush="true"/>
    <div class="container">
        <center><h2>Register</h2></center>
        <hr>
        <br>
        <c:choose>
            <c:when test="${message == 'Failed'}">
               Registration failed.
            </c:when>
            <c:when test="${message == 'Duplicate'}">
               Email has already used.
            </c:when>
            <c:otherwise>
               <!-- No comment -->
            </c:otherwise>
        </c:choose>
        <div class="center">
            <form name="register" class="register" action="register" method="post">
                <input type="text" id="name" name="name" placeholder="Name"><br>
                <input type="text" id="email" name="email" placeholder="Email"><br>
                <input type="password" id="pass" name="pass" placeholder="Password"><br>
                <input type="password" id="passcheck" name="passcheck" placeholder="Type your password again"><br>
                <div class="div-right-button">
                    <input type="submit" class="right-button" value="Register">
                </div>
                </form>
        </div>
    </div>
<script src="assets/js/validation.js"></script>
<jsp:include page="/views/footer.jsp" flush="true"/>
