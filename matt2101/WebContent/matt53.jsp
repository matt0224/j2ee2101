<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
     application.setAttribute("x", 123); //第二個參數 java數字也是物件
     request.setAttribute("x", (int)(Math.random()*49+1));
                         //上面key1都改成x
     String x= request.getParameter("x"); //接收參數
     
     
     Integer intX= (int)request.getAttribute("x");//12列抽出來
     out.println(x+"<br/>");//13烈的 x
     out.println(intX);
       //11烈的數字是matt54開始的
     
     
     
     
  %>
</body>
</html>