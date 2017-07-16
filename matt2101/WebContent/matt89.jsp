<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="matt"  %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<matt:test1/>

<hr>
<matt:test2 user="matt"/>


<hr>
<matt:test3 x="10" y="3">

${add }
</matt:test3>

<hr>
<matt:test5 name="Mouse" id="001" price="100"/>
</body>
</html>