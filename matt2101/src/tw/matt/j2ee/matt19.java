package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//controller 柳覽器都認這個C
@WebServlet("/matt19")

public class matt19 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//0.prepare
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		if(x==null)x="0"; //這邊要先測試有沒有進去
		if(y==null)y="0";
		
		//1.model 邏輯都放這
		matt20 model=new matt20(x,y);
		int result =model.add();
		
		//2.forward->view
		request.setAttribute("x", x);
		request.setAttribute("y", y);//x,y都是字串
		request.setAttribute("result", result);//物件
		request.getRequestDispatcher("matt21").forward(request, response);
										//這邊21才是sevlet
		
	}



}
