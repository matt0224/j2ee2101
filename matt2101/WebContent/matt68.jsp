<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="tw.matt.beans.mattUtil" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  //scope範圍
    //1.page  本頁
    pageContext.setAttribute("name", "<h1>matt.Co</h1>"); //這邊是字串也可以變成前端js css html
    //2.request  跟隨前頁Attribute
    request.setAttribute("name", "request");
    //3.session  
    session.setAttribute("name", "session");
    //4.application
    application.setAttribute("name", "app");
    

%>

name:${pageScope.name}<br>
request:${requestScope.name}<br>
session:${sessionScope.name}<br>
app:${applicationScope.name}<br>
1. m1(): <%= mattUtil.m1("matt")   %><br> <!-- static 不用物件實體直接摳 -->
2. m1(): ${mattUtil.m1(param.name) } <br> <!-- el不用寫在< % % >裡面 -->
</body>
</html>