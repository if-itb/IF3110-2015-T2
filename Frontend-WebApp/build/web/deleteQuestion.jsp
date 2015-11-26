<%-- 
    Document   : deleteQuestion.jsp
    Author     : moel
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Simple StackExcahange | Question</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <%
            int qid = Integer.parseInt(request.getParameter("id"));

            
            //getting token
            String token = (String)session.getAttribute("access_token");
            if (token == null) {response.sendRedirect("signin.jsp");}
            else{
                Calendar limcal = ((Calendar)session.getAttribute("start"));
                Integer lifetime = (Integer)session.getAttribute("lifetime");
                limcal.add(Calendar.SECOND, lifetime);
                if (limcal.before(Calendar.getInstance())){
                    response.sendRedirect("signin.jsp");
                }else{
                    String str;
                    QuestionModule.QuestionWS_Service qservice = new QuestionModule.QuestionWS_Service();
                    QuestionModule.QuestionWS port = qservice.getQuestionWSPort();
                    String alert;
                    String url = "";
                    
                      str = port.deleteQuestion(token, qid);
                      
                      // = Integer.toString(qid);
                      if (qid<0){
                        alert = "failed";
                        url = "/index.jsp";
                      }else{
                        alert = "Success";
                        url = "/Frontend_Webapp/displayQuestion.jsp?id=" + str;
                      }
                    }



                    out.write("<script type='text/javascript'>\n");
                    out.write("alert('"+alert+"');\n");

                    out.write("setTimeout(function(){window.location.href='"+url+"'},1000);");
                    out.write("</script>\n");
                }
            }
            
          %>
    </body>
</html>
