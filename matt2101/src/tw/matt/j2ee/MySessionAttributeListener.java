package tw.matt.j2ee;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener

//監聽器都是普通類別
public class MySessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
	   // event.getSession();
	  String name=event.getName();
	  String value= (String)event.getValue();
	  System.out.println("add:"+name+":"+value);
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
	   String name=event.getName();
	   String value= (String)event.getValue();
	   System.out.println("remove:"+name+":"+value);
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name=event.getName(); //換掉的之前
		String value= (String)event.getValue();
		System.out.println("replace:"+name+":"+value);
		
		HttpSession session=event.getSession(); //換掉之後 從新抓session回來
		String v2=(String)session.getAttribute(name);
		System.out.println("replacev2"+name+":"+v2);
		
	}

}
