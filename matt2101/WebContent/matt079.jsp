<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%-- 目的 表單查詢 --%>
<%-- redirect沒帶參數直接跳轉--%>
<c:if test="${empty param.editid and empty param.id }"> 
<c:redirect url="matt78.jsp"/>
</c:if>


<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1:3306/matt01"
	user="root" password="root" />	
	<%-- 有帶參數更新出現表單更改後更新--%>
<c:if test="${!empty param.id}">
	<sql:update var="count">
	
	   update member set account=?,passwd=?,realname=? where id=?
		<sql:param>${param.account}</sql:param>
		<sql:param>${param.passwd}</sql:param>
		<sql:param>${param.realname}</sql:param>
		<sql:param>${param.id}</sql:param>
	</sql:update>
	<c:redirect url="matt78.jsp"/>
</c:if>	

<sql:query var="result">
		select *from member where id=?		
		<sql:param>${param.editid }</sql:param>
</sql:query>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--影藏藍位 下面的hidden 這邊拿得id最上面sql param.id也會拿到id  --%>
<form action="UpdateData" >
  <input type="hidden" name="id" value="${result.rows[0].id }"> <br>
  Account:<input type="text" name="account" value="${result.row[0].account}"/><br>
  Password<input type="password" name="passwd" value="${result.row[0].passwd}"/><br>
  Real Name:<input type="text" name="realname" value="${result.row[0].realname}"/><br>
  <input type="submit" value="Update"/>
  
     

</form>

</body>
</html>

