package tw.matt.j2ee;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
                                   //過濾沒辦法做非同步
                                   //要過濾近來的url一定要有iii
                                   //這邊的*是針對 "路徑"非名稱所以會改matt01成iii/matt01才能過濾他
          //監聽器普通類別                                      //這邊的條件式過濾全部"/*"  ->改成matt01就過去他它就不能過
@WebFilter(filterName="mattFilter",urlPatterns= {"/iii/*"})   //這邊是過慮非監聽 //裡面就是目標物
public class MyFilter implements Filter {
	

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter init");
		
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("doFilter :bf");
		
		 String user=  req.getParameter("user");  //要帶參數而且是matt才能看到資訊
		 if(user!=null && user.equals("matt")) {   //user的參數等於matt才看的到
		  chain.doFilter(req, resp);  //i am matt卡在中間
		 }
		
		//chain.doFilter(req, resp);  //i am matt卡在中間
		System.out.println("doFilter :af");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter destroy");
	}

	


}
