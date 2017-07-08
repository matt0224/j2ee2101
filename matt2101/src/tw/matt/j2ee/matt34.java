package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//抽象類別 不能用Lambda 但週期只出現在程式 無法顯是在網頁
@WebServlet("/matt34")
public class matt34 extends HttpServlet {
	int i;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();  //要輸出資料要給這三行
		request.setCharacterEncoding("UTF-8");
		
		new Timer().schedule(new MyTask(),1000,1000);
	}
	
	private class MyTask extends TimerTask{
		@Override
		public void run() {
	    System.out.println(i++);
		}
	}

}
