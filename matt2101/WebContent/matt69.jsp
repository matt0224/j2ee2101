<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="member" class="tw.matt.beans.Member"/> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   pageContext.setAttribute("x", "123");
%>
<c:out value="${'hello'}" /><br><!-- 裡面的字串用單影 -->
<c:out value="${x }" default="no value" /><br><!-- 跟$的輸出插在default -->
<c:set var="var1" value="123" scope="page" /><br>
${var1 }<br>
<c:set var="var2"> <!-- c:set通常都在放html -->
321
${var1+321 }
<% out.print("OK"); %>
</c:set>
${var2 }<br>
<c:set target="${member  }" property="id"> <!-- id是物件的id -->
009
</c:set> 
<c:set target="${member  }" property="name"> <!-- name是物件的name -->
john
</c:set>
${member }<br>
<c:remove var="var1" />
<c:out value="${var1 }" default="no value" /><br> <!-- 移除全部All scopes -->
</body>
</html>