package tw.matt.j2ee;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyserverListenerV2 implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		ServletContext  servletContext  =event.getServletContext(); //因為這邊是context所以是app等級的
		
		
		List<AsyncContext> asyncs=new LinkedList<>(); //準備一個堆疊結構 用list //創了一個容器給大家用
		servletContext.setAttribute("asyncs", asyncs);
		
		//後續財家的
		    
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evnent) {
		// TODO Auto-generated method stub
		
	}

}
