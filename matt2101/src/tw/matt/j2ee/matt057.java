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

@WebServlet(urlPatterns="/matt057", asyncSupported=true)
public class matt057 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs = (List)servletContext.getAttribute("asyncs");
		synchronized (asyncs) {
			AsyncContext async = request.startAsync();
			//System.out.println(async.getTimeout());
			async.setTimeout(900000000);
			asyncs.add(async);
		}
	
	}

}