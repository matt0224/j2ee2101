package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.matt.beans.MemberV2;

/**
 * Servlet implementation class main2
 * 
 * 這是control 畫面不在這邊做
 */
@WebServlet("/main2")
public class main2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		       
		HttpSession session=request.getSession(false);
		if(session.getAttribute("member")==null) { //看身上有沒有member物件
			//view
			response.sendRedirect("login"); //交給另一個control 人已經走了不用retuen
			     
		}else {
			
		
		//System.out.println(((MemberV2)session.getAttribute("member")).getRealname()); //證明session有在裡面
		//view
		request.getRequestDispatcher("main2.jsp").forward(request, response); //把東西都帶走session也是
		              //上面這行有member的物件實體 //換上面的指向 這是control的動作
	}

	}

}
