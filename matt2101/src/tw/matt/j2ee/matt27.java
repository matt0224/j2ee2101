package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//cookie
//
@WebServlet("/matt27")
public class matt27 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//輸出文字資料
		request.setCharacterEncoding("UTF-8");
		
		Cookie cookieRemember =new Cookie("remember", "true");   //只能儲存任何""一組""永遠都字串 //也可改f就寫不進去
		cookieRemember.setMaxAge(1*60); //以秒計 cookie秒數 開發初期短一些
		//以上只在記憶體
		//網頁要找respone
		response.addCookie(cookieRemember); //重cookie use response
		
		Cookie cookieAccount =new Cookie("account", "matt");   //只能儲存任何""一組""永遠都字串
		cookieAccount.setMaxAge(1*60); //以秒計 cookie秒數 開發初期短一些
		//以上只在記憶體
		//網頁要找respone
		response.addCookie(cookieAccount); //重cookie use response
		
		Cookie cookiePasswd =new Cookie("passwd", "123456");   //只能儲存任何""一組""永遠都字串
		cookiePasswd.setMaxAge(1*60); //以秒計 cookie秒數 開發初期短一些
		//以上只在記憶體
		//網頁要找respone
		response.addCookie(cookiePasswd); //重cookie use response
		
		 //從一組改成三組
		
		
		
	}


}
