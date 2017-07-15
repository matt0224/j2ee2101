package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import tw.matt.beans.MemberV2;

/**
 * Servlet implementation class NewMember
 */
@WebServlet("/NewMember")
public class NewMember extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//輸出文字資料  //要輸出資料要給這三行
		request.setCharacterEncoding("UTF-8");
		
		//1: prepare
		String account=request.getParameter("account");
		String passwd=request.getParameter("passwd");
		String realname=request.getParameter("realname");
		
		//2.model
		try {
		MemberV2  member= new MemberV2();
		member.setAccount(account);
		member.setPasswd(passwd);
		member.setRealname(realname);
		boolean result=member.newInsert();
		
		//view 
		request.setAttribute("result", result); //布林的結果得到  
		request.getRequestDispatcher("result.jsp").forward(request, response); //forword到新頁面 因為這行最前面有request
		}catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("syserror.jsp").forward(request, response);
		}
		
	}

	

}
