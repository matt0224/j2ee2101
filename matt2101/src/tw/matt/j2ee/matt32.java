package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登出 跑32摧毀 跑31就沒了 30重session 跑31就有了
@WebServlet("/matt32")
public class matt32 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();  //要輸出資料要給這三行
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession(false);
		if(session==null){
			out.println("no session");
			return ;
		}else {
			session.invalidate();//失效
		}
		
	}

}
