package tw.matt.j2ee;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag2  extends SimpleTagSupport{
     StringWriter sw =new StringWriter(); //原本沒東西 準備一個串流writer
	 @Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		JspContext context = getJspContext();
		JspWriter out = context.getOut(); //原本輸出的
		      
		   JspFragment  body= getJspBody();  //回傳比較特別
		   
		   body.invoke(sw);  //把串留給他用 body是物件 類似html的innerhtml 再把物件丟進去body
		    
		   String  mesg=sw.toString();
		   
		   out.print("hello,"+mesg.toUpperCase());  //最後這行讀出來
	}
}
