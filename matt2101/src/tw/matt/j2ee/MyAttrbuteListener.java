package tw.matt.j2ee;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

//普通類別好東西再event
@WebListener
public class MyAttrbuteListener  implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
	  String attributeName=event.getName();
	 // String attributevalue=(String)event.getValue();
	    System.out.println("add"+attributeName);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		 String attributeName=event.getName();
		  String attributevalue=(String)event.getValue();
		    System.out.println("remove"+attributeName+"="+attributevalue);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		 String attributeName=event.getName();
		  String attributevalue=(String)event.getValue();
		    System.out.println("replace"+attributeName+"="+attributevalue);
	}

}
