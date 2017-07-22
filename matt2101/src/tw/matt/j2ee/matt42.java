package tw.matt.j2ee;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class matt42
 */  //42拿41得getattbute   ServletContext是全域application
@WebServlet("/matt42")
public class matt42 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext=getServletContext();
		System.out.println(servletContext.getAttribute("key3")); //拿到MyserverListener普通類別的key3 監聽拿到key3
		
			
		
		if(servletContext.getAttribute("key1")!=null) {
			 servletContext.removeAttribute("key1");
		}
		//System.out.println(servletContext.getAttribute("key1"));
	}

}
