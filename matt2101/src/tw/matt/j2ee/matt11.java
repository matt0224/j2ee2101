package tw.matt.j2ee;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//第一次結果是空白的  //後來改寫
/**   dir得絕對路徑要對上 parm value那邊
 * Servlet implementation class matt11
 */
@WebServlet("/matt11")
@MultipartConfig
public class matt11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private int counter;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 counter++;
		 response.setContentType("text/html; charset=UTF-8");
		 PrintWriter out =response.getWriter();
		 
		 Part part=request.getPart("upload");
		 
		 Collection<String> cc= part.getHeaderNames();
		 for(String header:cc) {
			 String v=part.getHeader(header);
			 out.print(header+":"+v+"<br />");
		 }
		 String filename =part.getSubmittedFileName();
		 out.print(filename+"<br>");
		 String name =part.getName();  // html input name;
		 long size =part.getSize();
		 out.print(name+":"+size);
		 
		 //開始讀取資料
		 byte[] buf=new byte[(int)size];
		 BufferedInputStream bin=
				 new BufferedInputStream(part.getInputStream());
		 bin.read(buf);
		 bin.close();
		 
		 ServletContext context= getServletContext();
		 Enumeration<String> names= context.getInitParameterNames();
		 while(names.hasMoreElements()) {
			 String pname=names.nextElement();
			 out.print(pname+"="+
			  context.getInitParameter(pname)+"<br>"); ///做到這邊沒有配置初始參數卡官
			 
		 }
		 
//		 String uploadPath =context.getInitParameter("upload-path");
//		  
//		 FileOutputStream fout=   //這邊是成功的
//		 new FileOutputStream(
//				 new FileOutputStream(new File(uploadPath,filename));
//				 
//
//				  fout.write(buf);
//		          fout.flush();
//		          fout.close();		 
//		 
//		File here = new File(".");
//		out.print(here.getAbsolutePath()); //得到絕對路徑的方法 上面跟這邊兩行
		
		
		 
//		 FileOutputStream fout=   這邊是成功的
//				 new FileOutputStream(
//						 "C:\\Users\\Mac\\git\\j2ee\\matt2101\\WebContent\\dir1"+filename);
		 FileOutputStream fout=
				 new FileOutputStream(
						 "/matt2101/WebContent/dir1/"+filename);
//		  fout.write(buf);
//          fout.flush();
//          fout.close();
		// part.getInputStream();
		 
		// request.getContentType();
		 String type=request.getContentType();
		 int len=request.getContentLength();
		 
		BufferedReader br=request.getReader();
		String line;
		while((line=br.readLine())!=null) {
			out.println(line+"<br>");
			
		}
		br.close();
		
		
		 response.getWriter().write("counter:"+counter);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
