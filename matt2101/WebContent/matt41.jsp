<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int a=10;%>
<%! int b=10; //有加驚嘆號會活在整個類別++等於static變數 static只有在matt41這個類別的%>
a=<%=a++ %>
b=<%=b++ %>
</body>
</html>