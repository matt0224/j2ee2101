package tw.matt.j2ee;

import java.io.IOException;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class matt57
 */  //收集要求
@WebServlet(urlPatterns="/matt57",asyncSupported=true)  //
public class matt57 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext=getServletContext();
		List<AsyncContext>  asyncs=(List)servletContext.getAttribute("asyncs");
		//從v2拿出資料 
		
		synchronized (asyncs) { //這邊是鎖定
			//asyncs.add(request.startAsync()); //這邊是已經丟進去了  //資料可能同時丟要鎖定
			AsyncContext async = request.startAsync(); //資料放進去AsyncContext
			async.addListener(arg0);
			//System.out.println(async.getTimeout()); 這邊的預設
			async.setTimeout(900000000);
			asyncs.add(async); //add 進去
		}
		
		
	}

}
