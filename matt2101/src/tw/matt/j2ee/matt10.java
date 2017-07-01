package tw.matt.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class matt10
 */
@WebServlet("/matt10")
public class matt10 extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String gender =request.getParameter("gerder");
	
		  String hobby =request.getParameter("hobby");
		//  String[] hobby =request.getParameterValues("hobby");
		
		response.setContentType("text/html; charset=UTF-8");
		//response.getWriter().write(gender);
		StringBuffer sb= new StringBuffer();
		
		
	//	response.getWriter().write(hobby);
	}



}
