package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class matt07
 */
@WebServlet("/matt07")
public class matt07 extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	   int x= Integer.parseInt(request.getParameter("x")) ;
	   int y= Integer.parseInt(request.getParameter("y")) ;
	   int result=x+y;
	   response.setContentType("text/html; charset=UTF-8");
	   PrintWriter pw =response.getWriter();
	   pw.write(x+"+"+y+"="+result);  //write 輸出的是int式不可列印字元
	   pw.flush();
	   pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
