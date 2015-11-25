<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@page import= "java.net.URL,javax.xml.namespace.QName,javax.xml.ws.Service" %>
<%@ page import="com.yangnormal.sstackex.*" %>
<%

	String id = request.getParameter("id");
	String token = request.getCookies()[0].getValue();
	if (id!=null) {
		URL url = new URL("http://localhost:8082/ws/stackexchange?wsdl");
		QName qname = new QName("http://ws.sstackex.yangnormal.com/", "WebServiceImplService");
		WebServiceImplService webService = new WebServiceImplService(url, qname);
		WebServiceInterface ws = webService.getWebServiceImplPort();
		int status = ws.deleteQuestion(1,Integer.parseInt(id),token);
		request.setAttribute("status",status);
		request.setAttribute("name","Delete Question");
		RequestDispatcher dispatcher = request.getRequestDispatcher("status.jsp");
		dispatcher.forward(request,response);
	}
%>