package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class matt54
 */
@WebServlet("/matt54")
public class matt54 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//輸出文字資料
		request.setCharacterEncoding("UTF-8");
		
//		try {
//			Thread.sleep( 30 * 1000);
//		} catch (InterruptedException e) {
//		}
//		
		out.print("OK:" + (int)(Math.random()*49+1));
		
	
	}
}
