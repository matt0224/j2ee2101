package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 這邊要改 呈現是一直跑
@WebServlet("/matt33")
public class matt33 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();  //要輸出資料要給這三行
		request.setCharacterEncoding("UTF-8");
		
		//out.println("OK");
		
		new Thread(()-> {        //Lambda 介面才能用
			out.println("OK");    //ok放在這邊就看不到老師有解釋
			for(int i=0;i<20;i++) {
				out.println("OK"+i);  //這邊out是畫面
				System.out.println(i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) { //sorun with
				
				}
			}
		}).start();
		
	}

	
}
