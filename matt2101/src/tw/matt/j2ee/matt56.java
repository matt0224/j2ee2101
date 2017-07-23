package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class matt56
 */   //這支是做非同步 延遲回應   //這邊要跑出oK3
@WebServlet(urlPatterns="/matt56",asyncSupported=true)  //第一個動作設定非同步
public class matt56 extends HttpServlet {
	private ExecutorService executorService=
			Executors.newFixedThreadPool(1); //一個pool
	 AsyncContext asyncContext;
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();//輸出文字資料
		request.setCharacterEncoding("UTF-8");
		
		asyncContext=request.startAsync(); //這個是取出來
		 executorService.submit(new AsynRequest());  //會new出很多這個在下去拆解 //做事情(延遲很久)
		 //executorService 做記憶體 自動new出類似執行緒的動作
	}
	
	 @Override
	public void destroy() {
		executorService.shutdown();//針對任務
		super.destroy();
	}
	
	private class  AsynRequest implements Runnable{

		@Override
		public void run() {
		   try {
			Thread.sleep(30*1000); //30秒
			
			PrintWriter out = asyncContext.getResponse().getWriter();
			out.print("OK3"+(int)(Math.random()*49+1));
			asyncContext.complete(); //完成
			
		} catch (Exception e) {
		}  
		
		   
		}
		
	}

}
