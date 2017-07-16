<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <c:set var = "theString" value = "I am a test String"/>
${ fn:contains(theString,'test')}   

<%
 String str=(String)pageContext.getAttribute("theString");
 out.print(str.contains("test"));  //跟上面是一樣的 test是取出 字串出現test
%>
<hr>
<c:set var = "string1" value = "This is first String."/>
  <c:set var = "string2" value = "${fn:substringAfter(string1, 'is')}" />
  ==>${string2 }
</body>
</html>