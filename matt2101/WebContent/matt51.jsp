<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>matt company</h1>
<hr/>
<jsp:include page="matt52.jsp">
    <jsp:param name="x" value="123"/> 
     <jsp:param name="y" value="456"/> 
</jsp:include>
</body>
</html>