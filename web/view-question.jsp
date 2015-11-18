<%-- 
    Document   : view-question
    Created on : Nov 17, 2015, Nov 17, 2015 8:06:32 AM
    Author     : Fikri-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="include/header.jsp" %>
<%
    String sid = request.getParameter("id");
    int id = Integer.parseInt(sid);
%>
<div id="view-qeustion-page">
<!-- pertanyaan-->
	<div class="section">	
		<h2><% out.print(dbq[id].topic);%></h2>
		<div class="row">
			<div class="col vote">
				<div class = "vote-btn">
				<button type="button" onclick=""><i class="fa fa-chevron-up"></i></button>
				<p class = "number-vote" id=""><% out.print(dbq[id].vote);%></p>
				<button type="button" onclick=""><i class="fa fa-chevron-down"></i></button>
				</div>
			</div>
			<div class="col content">
				<p><% out.print(dbq[id].content);%></p>
				<br>
			</div>
		</div>
		<div class = "row info" align = "right">
			Ditanyakan oleh <span class="name"><% out.print(dbq[id].email);%></span> |
			<span class="link edit"> <a href= "question.jsp?id=<%out.print(id);%>">Edit</a> </span> | 
			<span class="link delete"> <a href= "javascript:delete_question(<% out.print(id);%>)" >Delete</a></span>
		</div>
		<br>
	</div>
<!-- Jawaban --> 
	<div class="section" id="answers">
		<h2>
                    <% /*
                <?php echo $row2['numAns']; ?> Jawaban</h2> <hr>
		<?php
			$query = "select * from answer where q_id = '".$q_id."' order by id";
			$data = mysql_query($query);
		?>
		<?php while($row3 = mysql_fetch_array($data)): ?> */
                %>
			<div class = "row">
				<div class = "col vote">
					<button type="button" id = "vote-btn" onclick=""><i class="fa fa-chevron-up"></i></button>
					<p class = "number-vote" id=""><% out.print(dba[id].vote);%></p>
					<button type="button" id = "vote-btn" onclick=""><i class="fa fa-chevron-down"></i></button>
				</div>
				<div class = "col content">
					<p> <% out.print(dba[id].content);%></p>
					<br>
				</div>
				<div class = "row info" align = "right">

					<p>Dijawab oleh <span class = "name"><% out.print(dba[id].email);%></span> </p>

				</div>
				<hr>
			</div>
		<% /* <?php endwhile; ?> */ %>
	</div>

<!-- Form untuk menjawab-->
	<div class="section" id="form-answer">
		<h2>Beri jawaban :</h2>
		<form class = "block" action = 'actions/post-answer.jsp?id=<% out.print(id);%>' name = "myForm" method = 'POST' onsubmit = "return(validateAnswer());">
			<ul>
				<input type = 'text' name = 'Nama' placeholder="Nama" maxlength = '60'></input>
				<input type = 'text' name = 'Email' placeholder="Email"  maxlength = '60'></input>
				<textarea rows = '100' cols = '100' placeholder="Jawaban" name = 'Jawaban'></textarea>
				<input type = 'submit' value = "Kirim"></input>
			</ul>
		</form>
	</div>
                        <%
	//<?php mysql_close($link); ?>
                %>
	</div>
</div>

<%@include file="include/footer.jsp" %>
