package tw.matt.j2ee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.RunnableScheduledFuture;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class matt46
 */   //46登入
@WebServlet("/matt46")
public class matt46 extends HttpServlet {
	private ServletContext context;
	private Connection conn1, conn2;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context=getServletContext();
		
		try {
			Connection	conn1 = (Connection)context.getAttribute("conn");
			Statement stmt = conn1.createStatement();
			
			
			   ResultSet  rs=stmt.executeQuery("select *from member where account='matt' and islogin=0");
			   if(rs.next()) {
				   HttpSession session=request.getSession();
					//String seccionId=session.getId();
					session.setMaxInactiveInterval(60);
					stmt.executeUpdate("update member set islogin=1 where account='matt'");
					session.setAttribute("dbid","1");
					System.out.println("new login");
					//System.out.println("OK2");
				}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
