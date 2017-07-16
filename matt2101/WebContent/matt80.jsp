<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1:3306/matt01"
	user="root" password="root" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 一條沒成功其他不會做 下面tran做一次性的直到commit -->
<sql:transaction >
   <sql:update  var="n" sql="insert into member (account,passwd,realname) value(?,?,?)">
   		<sql:param>tony</sql:param>
   		<sql:param>123</sql:param>
   		<sql:param>Tony</sql:param>
 
   </sql:update>
   <sql:query var="lastid"><%-- 跑上來 select跑上來 --%>
   		select last_insert_id() as newid
   </sql:query>
   
</sql:transaction>

<c:if test="${n>=1 }">
Last Id:${lastid.rows[0].newid }
</c:if>



</body>
</html>