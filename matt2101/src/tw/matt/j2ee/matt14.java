package tw.matt.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//多檔上傳這邊有點卡關無法上傳@MultipartConfig沒有 出現多重錯誤
/**
 * Servlet implementation class matt14
 */
@MultipartConfig
@WebServlet(
		urlPatterns = { "/matt14" }, 
		initParams = { 
				@WebInitParam(name = "123", value = "456", description = "789")
		})
public class matt14 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String uploadPath = getServletContext().getInitParameter("upload-path");
		 
		 Collection<Part> parts=request.getParts(); //介面的coll
			for(Part part:parts) {
//			Part part = request.getPart("upload");
			
			String header =part.getHeader("Content-Disposition");
			
			
			String filename=mattAPI.getHeaderFileName(header);
			if(filename!=null&&filename.length()>0) {
			part.write(uploadPath + "/" + filename);
			}
		}
	}

}
