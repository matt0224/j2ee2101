<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="tw.matt.beans.Member"/> <!--class位置賦予 new id給member 下面 property用  -->
<jsp:setProperty property="member" name="id" value="${param.id}"/> 
<jsp:setProperty property="member" name="name" value="${param.name}"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 welcome,${member.name} <!--直接印出 因為有tostring  -->
 welcome,${member}
 <jsp:getProperty property="name" name="member"/>
</body>
</html>