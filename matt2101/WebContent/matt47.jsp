<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  ERROR
<%
   out.println(exception);//隱含物件 exception可以做其他動作
                         //page相關的指示原素包含 page include tagib
                         
                         //要到柳覽器在跑得到47
%>  
</body>
</html>