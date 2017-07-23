package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class matt58
 */  //用91執行  //57收集後按58丟出   58執行應該是空白的
@WebServlet("/matt58")
public class matt58 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext=getServletContext();
		List<AsyncContext>  asyncs=(List)servletContext.getAttribute("asyncs"); //堆疊區
		System.out.println("0");
		try {
			synchronized (asyncs) {

				for (AsyncContext asyncContext : asyncs) {
					System.out.println("1");
					PrintWriter out = asyncContext.getResponse().getWriter();
					System.out.println("2");
					out.print("msg"+(int)(Math.random()*49+1));
					asyncContext.complete(); 
				}
				asyncs.clear(); //做了 處理list裡面的東西 //有的案例式不清
				
			};
			
		}
		catch(Exception e) {System.out.println(e.toString());}

		
		
	}
}
