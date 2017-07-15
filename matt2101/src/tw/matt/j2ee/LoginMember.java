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
 * Servlet implementation class LoginMember
 */
@WebServlet("/LoginMember")
public class LoginMember extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//1: prepare
				String account=request.getParameter("account");
				String passwd=request.getParameter("passwd");
			
				
		//2.model    
			   try {
					MemberV2 member = new MemberV2();
					member.setAccount(account);
					member.setPasswd(passwd);
					
					if (member.isValidMember()) { //畫面導到哪control決定 //握有realname
						
						// Login Success
						//out.println("OK");
						
						HttpSession session=request.getSession();
						session.setAttribute("member", member);
						response.sendRedirect("main2"); //這邊交給另一個control
					}else {
						// Login Failure
						out.println("XX");
						
					}
			   }catch (Exception e) {
				// TODO: handle exception
				   out.println("ee");
			}
	}

}
