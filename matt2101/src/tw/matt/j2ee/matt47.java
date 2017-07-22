package tw.matt.j2ee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class matt46 登入 47登出
 */
@WebServlet("/matt47")
public class matt47 extends HttpServlet {
	private ServletContext context;
	private Connection conn1, conn2;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context=getServletContext();
		
		try {
			Connection	conn1 = (Connection)context.getAttribute("conn");
			Statement stmt = conn1.createStatement();
			
			HttpSession session=request.getSession(false);
			if(session !=null) {
				
			}
			String seccionId=session.getId();
			stmt.executeUpdate("update member set islogin=1 where account='matt'");
			session.setAttribute("dbid","1");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
