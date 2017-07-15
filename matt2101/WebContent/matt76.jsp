<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1:3306/matt01"
	user="root" password="root" /> <!-- 這邊有ds 下面要datasouce=ds -->
<sql:query sql="select *from member" var="result"  /> <!--result全部都是 attbute -->
     <!-- result裡面的元素 -->
<c:forEach items="${result.rows}" var="row" >
${row.id }:${row.account }:${row.passwd }:${row.realname }<br>
</c:forEach>
<hr>
<sql:query var="result2">
select *from member
</sql:query>
<c:forEach items="${result2.rows}" var="row" >
${row.id }:${row.account }:${row.passwd }:${row.realname }<br>
</c:forEach>
<hr>
<sql:query var="result3">
select *from member where account=?
<sql:param>iii</sql:param>
</sql:query>
<c:forEach items="${result3.rows}" var="row" >
${row.id }:${row.account }:${row.passwd }:${row.realname }<br>
</c:forEach>
<hr>
${result.rows[0].account }


</body>
</html>