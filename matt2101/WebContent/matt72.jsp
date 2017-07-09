<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
      String[] names={"matt","111","Ok","world"};
  	  pageContext.setAttribute("names", names);
      pageContext.setAttribute("step", 1); 
   %>
<table border="1" width="100%">
       <tr>
	      <th>index</th>
	      <th>name</th>
	      <th>count</th>
	      <th>first</th>
	      <th>last</th>
       </tr> 
       <c:forEach items="${names }" var="name" varStatus="status"
        begin="1" end="3" step="${step }"><!-- step是從 ("step", 1)-->
         <tr>
         	<td>${status.index }</td>
            <td>${name }</td>
            <td>${status.count }</td>
            <td>${status.first }</td>
            <td>${status.last}</td>
         </tr>
       </c:forEach> 
</table>
<hr/>
<%
   String line="1,matt,male,0987-123456,2000-01-01,台中市南區";
   pageContext.setAttribute("line", line);
   
%>
<c:forTokens items="${line }" delims="," var="field"
         varStatus="status"><!--  delims分隔依據 ,${line }是要猜的 -->

${status.count }:${field }

</c:forTokens>
<hr/>
<c:import var="data" url="http://www.tutorialspoint.com/" />
<c:out value="${data }"  />

<c:import url="matt73.jsp" var="data2">

   <c:param name="x" value="1"/>
   <c:param name="y" value="2"/>
</c:import>
<c:out value="${data2 }" />
<!--< %
    String data =(String)data;   //東西拿到如何還原成 原本的物件
% >  -->

  
   
</body>
</html>