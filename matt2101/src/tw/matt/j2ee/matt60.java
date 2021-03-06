package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;

@WebServlet("/matt60")
public class matt60 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mesg = request.getParameter("mesg");
		// 更新資料庫訊息
		try {
			Connection conn = (Connection)getServletContext().getAttribute("conn");
			if (conn!=null) {                                    //serverlistener已經建立連線
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("insert into message (mesg) values ('" + mesg + "')");
			}
		}catch(Exception ee) {
			System.out.println(ee.toString());
		}
		
		// 發送
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs = (List)servletContext.getAttribute("asyncs");
		//從v2取出資料 因為57已經add了 鎖住不讓人新增 for each
		
		synchronized (asyncs) {
			for (AsyncContext asyncContext : asyncs) {
				System.out.println("send"); //除挫點
				
			
				
				HttpServletResponse resp = (HttpServletResponse)asyncContext.getResponse(); 
				resp.setContentType("text/html; charset=UTF-8"); //這邊有強制轉型 找出response東西
				PrintWriter out = resp.getWriter();
				out.print(mesg);
				asyncContext.complete();
			}
			asyncs.clear();
		};
		
		response.sendRedirect("matt93.html");
		
	}
	
	

}
