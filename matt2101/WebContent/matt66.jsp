<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL用法  $-->
<%
    String method=request.getMethod();
       
      //整個page  HttpServletRequest 這邊得到很多東西
       HttpServletRequest  req=
                   (HttpServletRequest)pageContext.getRequest();
      // pageContext. 有很多東西
       String queryuString = req.getQueryString();
     // if(request==req){
    	//  out.println("OK");
     // }
       String user=req.getParameter("user");
       String passwd=req.getParameter("passwd");
       String ip = req.getRemoteAddr();

%>
Method:<%=method %>
query:<%=queryuString %>
user:<%=user %>
passwd:<%=passwd %>
ip:<%= ip %>
<hr>
method:${pageContext.request.method } <br><!-- 呼叫 method屬性 getMethod();駝峰式得到屬性-->
query: ${pageContext.request.queryString}<br>
</body>
</html>