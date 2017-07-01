package tw.matt.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class matt03
 */
@WebServlet("/matt03")
public class matt03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
  
    public matt03() {
        super();
        System.out.println("matt03()");
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    //	super.service(request, response);  //老師的24行 這行偷呼叫doget的34行doget
    	System.out.println("service");
    	doGet(request, response);
    	doPost(request, response);  //下面的程式已經幫您做這件事了
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
