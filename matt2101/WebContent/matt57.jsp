<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="tw.matt.beans.*" %>
    <%
      // Member  member=new Member();  //把新pakeage 
      // member.setId("001"); member.setName("matt");
      Member  member2=new Member("002","matt");
      
      application.setAttribute("member", member2);
      member2.setId("003");
     
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  welcome, <%= member2 %>
  <%           // member.getName()>member
  
     member2.m1(); //執行m1方法
  %>
</body>
</html>