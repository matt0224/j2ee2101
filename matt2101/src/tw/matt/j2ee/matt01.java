package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

               
	//自動生成改成iii01.php
	@WebServlet("/III01.php")
	public class matt01 extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//System.out.println("doget");
			
			try(PrintWriter writer=response.getWriter()){ //用try使用自動關閉
			writer.write("hello,world");
			writer.flush();
		
			}
		}
	}


