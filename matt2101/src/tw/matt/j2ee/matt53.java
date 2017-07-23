package tw.matt.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class matt53
 */
@WebServlet("/matt53")
public class matt53 extends HttpServlet {
	
	@Override //執行17行  //過濾器在伺服器的前後已經拿到
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// before
		super.service(req, resp);
		//after
	}
	            //再doget拿到對方的req 其實在17已經拿到
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
