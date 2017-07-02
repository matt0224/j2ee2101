package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class matt15
 */
//include
@WebServlet("/matt15")
public class matt15 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("matt16?name=matt&status=OK"); //有點像父寫的觀念  這邊到get去 帶一些url基本參數
		
		
		RequestDispatcher dispatcher2 =
				request.getRequestDispatcher("matt16?name=matt&status=OK"); 
		out.print("<h1>123456</h1>");
		out.print("<hr/>");
		
		//include
		dispatcher.include(request, response);//傳遞進去跟傳遞出來了 //這邊把16號的插進來了直接改寫
		out.print("<hr/>");
		dispatcher2.include(request, response);
		
		out.print("<hr/>");
		out.print("copyleft");
		
		
	}


}
