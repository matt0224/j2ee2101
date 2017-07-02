package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//18的範例是url顯示18但是內容是參考17所以比較安全,類似mvc
@WebServlet("/matt18")
public class matt18 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("matt17?"); //用17的
		
		out.print("<h1>123456</h1>");
		out.print("<hr/>");
		//------------------spring mvc類似這邊  .do是以前sevrlet副檔名
		dispatcher.forward(request, response);//全部改成17的內容
		
		out.print("<h1>123456</h1>");
		out.print("<hr/>");
		
	}


}
