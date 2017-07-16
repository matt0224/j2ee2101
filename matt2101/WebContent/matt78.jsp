<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ page errorPage="error.jsp" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1:3306/matt01"
	user="root" password="root" />
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><!-- 執行78 修改到跳到79 修改後跳回78 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><!-- !empty 沒有空代表有參數6--> <%--${param.delid } --%>
<c:if test="${!empty param.delid }"> 
	<sql:update var="count">
 		delete from member where id=?
 		<sql:param>${param.delid }</sql:param>
	</sql:update>
</c:if>

<sql:query sql="select *from member" var="result"  />
<table border="1" width="100%">
	 <tr>
	 	<th>Id</th>
	 	<th>Account</th>
	 	<th>Password</th>
	 	<th>Real name</th>
	 	<th>delete</th>
	 	<th>edit</th>
	 </tr>
	 <c:forEach items="${result.rows}" var="row" >   
		  <tr>
		 	<td>${row.id }</td>
		 	<td>${row.account }</td>
		 	<td>${row.passwd }</td>
		 	<td>${row.realname }</td>
		 	<td><a href="?delid=${row.id }">delete</a></td>
		 	<td><a href="matt79.jsp?editid=${row.id }">edit</a></td>
		 </tr>
</c:forEach>

</table>
</body>
</html>

