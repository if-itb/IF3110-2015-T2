<%-- 
    Document   : index
    Created on : Nov 17, 2015, 8:16:41 PM
    Author     : acel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="Token.*"%>

<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    
<%--      
                String url = "http://localhost:8082/IdentityServices/GenerateToken"; 
		
		String USER_AGENT = "Chrome/46.0.2490.86";
                URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
                
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		out.println("\nSending 'GET' request to URL : " + url + "<br>");
		out.println("Response Code : " + responseCode + "<br>");

		try {
                    BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response1 = new StringBuffer();
                    
                    while ((inputLine = in.readLine()) != null) {
                            response1.append(inputLine);
                    }
                    in.close();
                    
                    //print result
                    out.println(response1.toString() + "<br>");
                } catch (Exception e){
                    
                }
--%>
    <form method="POST" action="/IdentityServices/Token">
        Username <input type="text" name="uname"><br>
        Password <input type="password" name="pword"><br>
        <button type="submit">Submit</button>
    </form>
    
    
    

