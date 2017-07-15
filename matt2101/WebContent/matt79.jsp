<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty param.editid and empty param.id }"> <%-- redirect沒帶參數直接跳轉--%>
<c:redirect url="matt78.jsp"></c:redirect>
</c:if>


<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1:3306/matt01"
	user="root" password="root" />	
	
	<c:if test="${!empty paramid}"> <%-- redirect沒帶參數直接跳轉--%>
	<sql:update var="count">
	
	   update member set account=?,passwd=?,realname=? where id=?
		<sql:param>${param.account}</sql:param>
		<sql:param>${param.passwd}</sql:param>
		<sql:param>${param.realname}</sql:param>
		<sql:param>${param.id}</sql:param>
	</sql:update>
	<c:redirect url="brad78.jsp"/>
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
<form >
  <input type="hidden" name="id" value="${result.rows[0].id }"> <%--影藏藍位 這邊拿得id最上面sql param.id也會拿到id  --%>
  <input type="text" name="account" value="${ result.row[0].account}"/><br>
  <input type="password" name="passwd" value="${ result.row[0].passwd}"/><br>
  <input type="text" name="realname" value="${ result.row[0].realname}"/><br>
  <input type="submit" value="update"/>
  
     

</form>

</body>
</html>