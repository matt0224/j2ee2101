package tw.matt.j2ee;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;



/**
 * Servlet implementation class matt40
 */    //第一個name是跟xml需要一樣
@WebServlet(name="/matt40",
urlPatterns= {"/matt40","/matt40.php","/matt40.aspx"},
      initParams= { //這邊預設值是空的
    	@WebInitParam(name="x",value="123"),
    	@WebInitParam(name="y",value="456"),
      }
		)
public class matt40 extends HttpServlet {
	 private ServletConfig servletConfig;
	 private ServletContext servletContext;
	@Override
		public void init() throws ServletException {
		System.out.println("init");  //跑完這邊跑service
			super.init();
		   servletConfig=getServletConfig();
		   servletContext=getServletContext();
		}
	
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	super.service(req, resp); //doGet or doPost 自己會跑
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Enumeration<String> params= servletConfig.getInitParameterNames();
		  while (params.hasMoreElements()) {
			 String param=params.nextElement();
			 System.out.println(param+"="+servletConfig.getInitParameter(param));//這邊可以呼叫使用到WebInitParam的參數
			
		}
		 String realPath= servletContext.getRealPath("/"); // . and / 跟目錄
		 System.out.println(realPath);
		 Set<String> paths= servletContext.getResourcePaths("/"); //抓到裡面的檔案 抓到跟目錄所有檔案
		  for(String path:paths) {
			  System.out.println(path);
		  }
		}
	}


