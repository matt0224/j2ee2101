package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

//撈 cookie  

//特徵是 key=value;key=value
//spdy(http變形)=line 通訊協定   

//執行 28沒有東西 執行27重cookie 在執行28看到更多cookie
@WebServlet("/matt28")
public class matt28 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//輸出文字資料
		request.setCharacterEncoding("UTF-8");
		
		String account="",passwd="";
		boolean isRemember =false;
		
		Cookie[] cookies=request.getCookies(); //拿到cookie用request
		HashMap<String, String> map =new HashMap<>();
		if(cookies !=null) { //因為現在沒有cookie 但有可能電腦有別的專案 是因為這個環境乾淨沒別的cookie
			
			
		
		for(Cookie cookie:cookies) {
			String name=cookie.getName();
			String value=cookie.getValue();
			map.put(name, value);
			
//			//out.print(name+":"+value+"<br/>");
//			if(name.equals("remember")&& value.equals("true")) {
//				isRemember=true;
//			}
//			
//			if(name.equals("account")) {
//				account=value;
//			}
//			if(name.equals("passwd")) {
//				passwd=value;
//			}  //判斷27號
			
		}
				
	} 
	    if(map.containsKey("remember")) {
	    	if (map.get("remember").equals("true")) {
				out.println(map.get("account") + " : " + map.get("passwd"));
			}else {
				out.print("no remember");
			}
		}else {
			out.print("no cookie");
		}
		
	}

}

	    
	    
		
//		if(isRemember) {
//		out.println(account+":"+passwd);
//		}else {
//			out.print("no remember");
//		}
			
//}
		
//}
//}
