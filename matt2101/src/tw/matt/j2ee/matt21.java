package tw.matt.j2ee;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/matt21")
public class matt21 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String x=(String)request.getAttribute("x");
		String y=(String)request.getAttribute("y");
		Integer result=(Integer)request.getAttribute("result");
		
		
		//以下有特別講解
		//load template view 這邊也可當成一個view
		//out.print(x+"+"+y+"="+result); //用這行來測試有沒有結果
		String html =loadView("mycal.html"); //html有幾個%s下面就要有多少
		//out.print(html);除錯用的
		html= String.format(html, x,y,result); //%s的三個按造順序來在mycal.html
		out.println(html);
		
	}
   
	private String loadView(String file) {
		String tempPath = getServletContext().getInitParameter("template-path");
		File viewFile = new File(tempPath, file);
		int len = (int)viewFile.length();
		byte[] buf = new byte[len];
		try {
			BufferedInputStream bin = 
				new BufferedInputStream(new FileInputStream(viewFile));
			bin.read(buf);
			bin.close();
		}catch(Exception e) {
			
		}
		
		return new String(buf);
	}
}
