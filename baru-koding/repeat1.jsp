
<%@ taglib prefix="mytag" uri="/WEB-INF/jsp2/jsp2-example-taglib.tld" %>
<html>
  <head>
    <title>Examples</title>
	<style>
.p1 {
    border-top-style: solid;
    border-right-style: white;
    border-bottom-style: white;
    border-left-style: white;
}
.p2 {
	border-style: solid;
    border-width: 1px;
}
.p3 {
    margin-top: 100px;
    margin-bottom: 100px;
    margin-right: 150px;
    margin-left: 50px;
}
.p4{
	font-size: large;
}
.p5{
	font-size: 32 pt;
}
.p6{
	padding: 1px 50px;
}
span { float: left; width: 5em; height: 5em; border: solid blue; }
</style>
  </head>
  <body>
 <br></br>
<center><p><H1> Simple Stack Exchange </H1></p></center><br>
<form method="POST" action="formhandlerservlet">
	<center> 
	<p><input type="text" name="nama" maxlength="240" size="80">
	<input type="submit" value="Search"></p>
	</center>
</form>
<center><label for="n">Cannot find what you are looking for?</label>
<a href="form.html">Ask here</a></center><br>
<table style="width:100%">
		<tr>
			<td style="width:15%"><p> </p></td>
			<td style= "width:70%"><p><label for="na"><p class="p4">Recently Asked Questions</p></label></p>
			<p class="p1"></p>
			<td style="width:15%"><p> </p></td>
		</tr>
</table>
<table style="width:100%">
	<mytag:repeat num="5">
		<tr>
			<td style="width:15%"><p> </p></td>
			<td style="width:5%"><p><center>  0 </center></p><p><center>Votes</center></p></td>
			<td style="width:5%"><p> </p></td>
			<td style="width:5%"><p><center>  0 </center></p><p><center>Answer</center></p></td>
			<td style="width:40%"><p><center>The question topic goes here</center></p></td>		
			<td style="width:20%"><p>
				<label for="nn"><br></br>asked by name </label>
				<label for="nn1"><b>|</b></label>
				<a href='gone.php? id=edit & act=edit'>edit</a>
				<label for="nn2"><b>|</b></label>
				<a href='gone.php? act=delete'>delete</a></p>
			</td>
			<td style="width:15%"><p> </p></td>
		</tr><br>
	</mytag:repeat>
</table>
</body>
</html>
