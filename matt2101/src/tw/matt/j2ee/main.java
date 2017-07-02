package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//進入點直接run
/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		ResultSet rs=null;
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("OK");
				              Properties prop  =new Properties();
				              prop.setProperty("user", "root");
				              prop.setProperty("password","root");
				Connection conn = DriverManager.getConnection(
						 "jdbc:mysql://127.0.0.1:3306/matt02", prop);
				
				 String delid=request.getParameter("delis");
				 if(delid!=null){
					conn.createStatement().executeUpdate("delete from cust WHere id="+delid); 
				 }
				
				
				System.out.println("OK"); //測試有無聯線
					PreparedStatement pstmt = 
						conn.prepareStatement(
							"select * from cust");
					
					rs=pstmt.executeQuery();
					
//					System.out.println("Insert OK");
			} catch (Exception e) {
				System.out.println(e);
			}
		
	
		
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
		out.println("<a href='AddAccount'>Add</a>");
		out.println("<hr />");
		out.println("<table border='1' width='100%'>");
		out.println("<script>");
		out.println("<tr>\r\n" + 
				"		<th>ID</th>\r\n" + 
				"		<th>Name</th>\r\n" + 
				"		<th>Password</th>\r\n" + 
				"		<th>delete</th>\r\n" + 
				"	</tr>");
		out.println("</table>");
		try {
		if(rs !=null) {
			while(rs.next()) {
				String id=rs.getString("id");
				String account=rs.getString("account");
				out.print("<tr>");
			//	out.print("<td>"+rs.getString("id")+"</td>");
				out.print("<td>"+rs.getString("account")+"</td>");
				out.print("<td>"+rs.getString("passwd")+"</td>");
				out.print("<td><aherf='?delid="+id+
						"'onclick='return confirm(\"Delete"
						+account+"?\");'>Delete</a></td>");//超連結利用到自己刪除,然後會問
				out.print("</tr>");	
			}
		}
		}catch (Exception e) {
		}
	}

}
