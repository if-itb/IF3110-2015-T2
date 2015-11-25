<%-- 
    Document   : index
    Created on : Nov 17, 2015, Nov 17, 2015 8:05:49 AM
    Author     : Fikri-PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<%@include file = "include/header.jsp" %>     
        <div id="main-page" onload="function() {document.getElementById('autofocus').focus();}">
                <div id="main-search" class="center">
                <form action = 'search.jsp' id = "main-search" method = 'GET'>
                        <ul>
                                <input type = 'text' id = "search-bar" name = 'key' maxlength = '160' placeholder = "Cari disini" required>
                                <input type = 'submit' value = 'Cari'>
                        </ul>
                </form>
                <p> 
                        Tidak dapat menemukan yang anda cari ? Tanyakan <a href = "question.jsp">disini!</a>
                </p>
                </div>
                <div class = "question">
                <span class = "page-title"><h3>Pertanyaan baru-baru ini</h3></span> <hr>
                <% for(int i=0; i<10; i++) { %>
                    <div class="row">
                    <h2> <a href = view-question.jsp?id=<% out.print(dbq[i].id); %>><% out.print(dbq[i].topic); %></a></h2>
                    <p> <% out.print(dbq[i].content); %></p>
                    <br>
                    <div class="col vote in-numbers">
                        <div class = "flag">Vote</div>
                        <div class = "number"> <% out.print(dbq[i].vote); %></div>
                    </div>
                    <div class = "col answers in-numbers">
                        <div class = "flag">Jawaban</div> <div class = "number">2</div>
                    </div>
                    <div class = "controls" align = "right">
                        Ditanyakan oleh <span class="name"><% out.print(dbq[i].name); %></span> |
                        <span class="link edit"> <a href= "question.jsp?id=<% out.print(dbq[i].id); %>">Edit</a> </span> | 
                                                <span class="link delete"> <a href= "javascript:delete_question(<% out.print(dbq[i].id); %>)" >Delete</a></span>
                                        </div>
                                </div>
                                <br><hr>
                <% } %>
                </div>
        </div>
<%@include file="include/footer.jsp" %>