<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    //這隻要跑在google上才能動
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=
    		 DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/matt01","root","root");
    Statement stmt=conn.createStatement();
    String sql=("insert into member(account,passwd,realname) values('mate','33','mate')");
    stmt.execute(sql);
    out.print(10/0);
%>


</body>
</html>