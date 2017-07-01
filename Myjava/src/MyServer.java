import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.DocFlavor.READER;

public class MyServer {
//網頁從新整理兩次資料會跑來這邊
	public static void main(String[] args) {
	  try(ServerSocket server=new ServerSocket(4567);
			  Socket socket= server.accept();
			  BufferedReader reder=
					  new BufferedReader(
					     new InputStreamReader(
					    		 socket.getInputStream()));
			  ){
		  String line =null; StringBuffer sb=new StringBuffer();
		  while ((line=reder.readLine())!=null) {
			  sb.append(line+"\n");
			
			  
		  }
		  
		  System.out.println(sb);
		  //Socket socket= server.accept();
		 // BufferedReader reder=new BufferedReader(new InputStreamReader( socket.getInputStream()));
		  
		   //socket.getInputStream();
		  
	  }catch(Exception e) {
		  System.out.println(e);
	  }

	}
}
