<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@page isELIgnored="false" %>  加上這個全部忽略-->  
    <%@page import="java.util.*" %>
<%
	String[] names={"matt","aaa","OK"};
    request.setAttribute("usernames", names); //要是物件才能擺進去給下面用
      LinkedList<String> list =new LinkedList<>();
      list.add("AAA");
      list.add("BBB");
      list.add("CCC");
      request.setAttribute("list",list);
      
      HashMap<String,String> map= new HashMap<>();
      map.put("name", "matt");
      map.put("account", "Matt");
      map.put("passwd", "123456");
      request.setAttribute("map", map);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 Name1:${usernames[0]}<br>
 List1:${list[param.i] }<br> <!--list [0]->可以下參數的 list[param.i] -->
 Account:${map["account"] }<br>
 ${10 + 3 }<br>
${(param.i=="1")? "yes" : "no" }<br>
${1 > 3 }<br><!-- 出 t or f -->
${"a" < "b" }<br>
${"12" > 3 }<br>


</body>
</html>