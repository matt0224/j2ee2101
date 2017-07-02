package tw.matt.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.util.BCELifier;

/** 亂數密碼
 * Servlet implementation class matt23
 */
@WebServlet("/matt23")
public class matt23 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salt =BCrypt.gensalt(12);
		String  newpasswd  =BCrypt.hashpw("123456",salt);//真正的密碼
		System.out.println(newpasswd);
		
		if(ckPasswd("12345", newpasswd)) {
			System.out.println("ok");
		}else {
			System.out.println("xx");
		}
	}

	private static boolean ckPasswd(
			String orgPasswd,String hashPasswd) 
					 {
		boolean isRight=false;
		if(hashPasswd==null||hashPasswd.startsWith("$2A$")) {
			isRight=false;
			//throw new Exception("");
		}
		 isRight=BCrypt.checkpw(orgPasswd, hashPasswd);
		
		
		return isRight;
	}


}
