package tw.matt.j2ee;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//用25開
@WebServlet("/matt24")
public class matt24 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html; charset=UTF-8"); //文字用
		response.setContentType("image/jpeg");//對比上面這是照片資料  畫圖用  jpeg windows規定
		
		String rate=request.getParameter("rate");
		float floatRate= Float.parseFloat(rate); //可能出現RUNTIME
		
		BufferedImage bimg=new BufferedImage(400, 20, BufferedImage.TYPE_INT_BGR) ;//長寬,型態  得到g物件實體
		Graphics2D g2d=bimg.createGraphics();
		
	    g2d.setColor(Color.yellow);
	    g2d.fillRect(0, 0, 400, 20); //填滿上面
	    g2d.setColor(Color.red);
	    g2d.fillRect(0, 0, (int)(400*floatRate/100), 20); //填滿上面
	    
	    
	    //以上記憶體上做的動作
	    
	    
	    //output 開始輸出  bimg g2d out找方法
	    OutputStream out= response.getOutputStream();
	    ImageIO.write(bimg, "jpeg", out); // ImageIO 常用
	    out.flush();
	    out.close();
	    
		
	}
}
