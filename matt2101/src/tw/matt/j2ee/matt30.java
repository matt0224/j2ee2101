package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//用戶端跟賜福端   建立出物件實體 session
@WebServlet("/matt30")
public class matt30 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=
				request.getSession(); //取得session //重點 如果沒有存在,就建立一個session的物件實體
		
//		HttpSession session=
//      request.getSession(true); // 用布林 some as 上面建立
		
//		HttpSession session=
//      request.getSession(false); //if not exist,that is 沒有的話把人趕走
		    Member member=new Member("matt", 27);
		   session.setAttribute("who", member);
		
	}

}
