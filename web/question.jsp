<%-- 
    Document   : question
    Created on : Nov 17, 2015, Nov 17, 2015 8:06:01 AM
    Author     : Fikri-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="include/header.jsp" %>
        <h2>Apa pertanyaan anda ?</h2> <hr>
        <%
            String sid = request.getParameter("id");
            if(sid != null){
                String name, email, topic, content;
                int id = Integer.parseInt(sid);
                for(int i = 0; i<10; i++){
                    if(dbq[i].id == id){
                        name = dbq[i].name;
                        email = dbq[i].email;
                        topic = dbq[i].topic;
                        content = dbq[i].content;
                    }
                }
        %>
        <form class="block" action = 'actions/post.jsp?id=<% out.print(id); %>' name = "myForm" method = 'POST' onsubmit = "return(validateQuestion());">
                <ul>
                        <input type = 'text' name = 'Nama' placeholder="Nama" value = "<% out.print(dbq[id].name); %>" maxlength = '60'></input>
                        <input type = 'text' name = 'Email' placeholder="Email" value = "<% out.print(dbq[id].email); %>" maxlength = '60'></input>
                        <input type = 'text' name = 'Topik' placeholder="Topik" value = "<% out.print(dbq[id].topic); %>" maxlength = '140'></input>
                        <textarea rows = '100' cols = '100' placeholder="Konten" name = 'Konten' ><% out.print(dbq[id].content); %></textarea>
                        <input type = 'submit' value = "Update"></input>
                </ul>
        </form>
        <% } else {%>
        <form class="block" action = 'actions/post.jsp' name = "myForm" method = 'POST' onsubmit = "return(validateQuestion());">
                <ul>
                        <input type = 'text' name = 'Nama' placeholder="Nama" maxlength = '60'></input>
                        <input type = 'text' name = 'Email' placeholder="Email"  maxlength = '60'></input>
                        <input type = 'text' name = 'Topik' placeholder="Topik" maxlength = '140'></input>
                        <textarea rows = '100' cols = '100' placeholder="Konten" name = 'Konten' ></textarea>
                        <input type = 'submit' value ="Kirim"></input>
                </ul>
        </form>
        <% } %>
<%@include file="include/footer.jsp" %>
