package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//跑31完跑30 再回到31看session 可以存物件
//cookie不可存物件
@WebServlet("/matt31")
public class matt31 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//輸出文字資料  //要輸出資料要給這三行
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession(false);
		if(session==null){
			out.println("no session");
			return ;
		}
		
		Member member=(Member)session.getAttribute("who"); //有可能沒who 第二個可能不是member 所以要try
		out.print(member.getname()+":"+
		       member.getage());
	}
}
