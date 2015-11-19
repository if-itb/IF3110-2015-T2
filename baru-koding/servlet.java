
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormHandlerServlet extends HttpServlet {
	
protected void doPost(HttpServletRequest request,
	HttpServletResponse response) {
		String enteredValue;
		enteredValue = request.getParameter("nama");
		response.setContentType("text/html");
		PrintWriter printWriter;
		try {
			printWriter = response.getWriter();
			printWriter.print("<html>");
			printWriter.print("<p>Teks: ");
			printWriter.print(enteredValue);
			printWriter.print("</p>");
			printWriter.print("</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}