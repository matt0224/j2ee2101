<%@page import="javax.print.attribute.standard.Severity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
<%@ page import = "org.apache.commons.io.output.*" %>    
<%  //檔案要字創一個檔案放在c:\\matt\\temp  
	int maxFileSize = 5000 * 1024;
	int maxMemSize = 5000 * 1024;
	
	 DiskFileItemFactory factory = new DiskFileItemFactory();
     // maximum size that will be stored in memory
     factory.setSizeThreshold(maxMemSize);
     
     // Location to save data that is larger than maxMemSize.
     factory.setRepository(new File("c:\\matt\\temp"));
  String uploadPath=
  	pageContext.getServletContext().getInitParameter("upload-path");

    ServletFileUpload upload= new ServletFileUpload(factory); //這邊是用戶端上傳檔案的一個物件
    List<FileItem> items = upload.parseRequest(request);
  
    
    int i=1;
    for(FileItem item:items){   //把file解出來
      String name=item.getName();
      long size =item.getSize();
      String fname=item.getFieldName();
      boolean isMem=item.isInMemory();
      out.print(name+":"+size+":"+fname+":"+isMem+"<br>");
      item.write(new File(uploadPath,"matt"+ i++ +".png")); //uploadPath是路徑改成後面檔案改成變數
    
    }
    
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>