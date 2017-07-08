package tw.matt.j2ee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;

import com.sun.prism.Image;

/**
 * Servlet implementation class matt26
 */ //直接開 浮水印
@WebServlet("/matt26")
public class matt26 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("image/png");
	     String imgPath =
	    		 getServletContext().getInitParameter("upload-path");
	   java.io.File imgFile=new java.io.File(imgPath, "123.png");
	   
	   BufferedImage bimg=ImageIO.read(imgFile);
	   Graphics2D g2d=bimg.createGraphics();
	   
	   //做劃
	      Font font=new Font(null, Font.BOLD+Font.ITALIC, 48);
	      
	         AffineTransform tran  =new AffineTransform();
	         tran.rotate(Math.toRadians(45),100,0); //按造字的基線  //圖形驗證器
	         Font newfont= font.deriveFont(tran);
	      
	      g2d.setFont(newfont);
	      g2d.setColor(Color.green);
	      g2d.drawString("hello123",100 ,200 );
	      
	      
	   
	   //out
	   java.io.File outFile=new java.io.File(imgPath, "123.png"); //檔案跟螢幕億一起輸出
	   OutputStream out =response.getOutputStream();
	   ImageIO.write(bimg, "png", out);
	   
	   
	   //ImageIO.write(bimg, "png", outFile);
	   
	   out.flush();
	   out.close();
	   
	  
	   
	    
	   
	}

}
