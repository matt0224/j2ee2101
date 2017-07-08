package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/matt29")
public class matt29 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//輸出文字資料
		request.setCharacterEncoding("UTF-8");
		try {
		int a=10,b=0;
		out.print(a/b);
		}catch (Exception ee) {
			response.sendError(
					HttpServletResponse.SC_BAD_GATEWAY, "Server Bz"); //錯誤505->502
		}
	}

}
