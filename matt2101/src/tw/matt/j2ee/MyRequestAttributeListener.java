package tw.matt.j2ee;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
//@WebListener  //執行58的時候要取消監聽不然 v2板會衝到
public class MyRequestAttributeListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		 String name=event.getName();
		  String value=(String)event.getValue();
		    System.out.println("request attribute add:"+name+"->"+value);
		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		String name=event.getName();
		  String value=(String)event.getValue();
		    System.out.println("request attribute  remove:"+name+"->"+value);
		
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		String name=event.getName();
	    
		//System.out.println("request replace attribute"+name);  因為有布遴用這個策是 但裡面有個非同步 為ture f 
		 //上為非同步
		
		if(name.equals("x")) {
		  String value=(String)event.getValue();
		    System.out.println("request attribute replace bf:"+name+"->"+value);
		    
		    ServletRequest req=event.getServletRequest();
			  String v2=(String)req.getAttribute(name);
			    System.out.println("request attribute replace af:"+name+"->"+v2);
		}
	}

}
