package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//新增資料庫失敗
/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String account=request.getParameter("account");
		String passwd=request.getParameter("passwd");
		if(account!=null) {
			//處理新增
			addAccount(account, passwd);
			response.sendRedirect("Main");  //這招是類似超連結
		}else {
			
		}
		
		out.println("<form>");
		out.println("Account:<input name=''/><br/>");
		out.println("Password:<input type='password' name='passwd' /><br/>");
		out.println("<input type='submit' value='add'/><br/>");
		out.println("</form>");
	}
  private void addAccount(String account, String passwd) {
	  String salt =BCrypt.gensalt(12); //雜湊密碼的
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("OK");
			              Properties prop  =new Properties();
			              prop.setProperty("user", "root");
			              prop.setProperty("password","root");
			Connection conn = DriverManager.getConnection(
					 "jdbc:mysql://127.0.0.1:3306/matt02",prop);
			System.out.println("OK"); //測試有無聯線
				PreparedStatement pstmt = 
					conn.prepareStatement(
						"INSERT INTO cust (account,passwd) VALUES (?,?)");
				pstmt.setString(1, account);
				
				pstmt.setString(2, BCrypt.hashpw(passwd,salt));
				//pstmt.setString(2, passwd); 改成上面的 雜湊密碼
				pstmt.executeUpdate();
				
				System.out.println("Insert OK");
		} catch (Exception e) {
			System.out.println(e);
		}
  }

}
