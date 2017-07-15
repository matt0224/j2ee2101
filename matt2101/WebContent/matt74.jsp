<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  Locale locale= request.getLocale();
%>
Locale <%=  locale.getCountry()%><br>
                 <%--要的 --%>
Locale <%= locale.getDisplayCountry() %><br>
                  <%--呈現的 --%>
Locale <%= locale.getLanguage() %><br>
<hr>
<fmt:setBundle basename="res"/>
<fmt:message key="Hello"/>,<fmt:message key="World"/>
<hr>
<fmt:message key="Co"/>

<%
  Date now=new Date();
  out.print(now);
  pageContext.setAttribute("now", now);
%>
<hr>
<fmt:setTimeZone value="Africa/Kampala"/><br>
<fmt:formatDate value="${now }" type="both" dateStyle="long"/>
<fmt:setTimeZone value="Asia/Taipei"/><br>
<fmt:formatDate value="${now }" type="both" dateStyle="long"/>
<hr>
Default:<fmt:formatNumber value="${123231.2421 }"/><br>
沒有千分位:<fmt:formatNumber value="${123231.2421 }" groupingUsed="flase"/><br>
Max 4 digit:<fmt:formatNumber value="${123231.2421 }" maxIntegerDigits="4"/><br>
Min 8 digit:<fmt:formatNumber value="${123231.2421 }" minFractionDigits="8" groupingUsed="flase"/><br>
Fraction max 2 digit:
<fmt:formatNumber value="${123231.2421 }" maxFractionDigits="2"/><br>
<fmt:formatNumber value="${123 }" type="currency" currencyCode="JPY"/>
</body>
</html>