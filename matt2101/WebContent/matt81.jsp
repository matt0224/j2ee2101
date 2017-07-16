<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 利用c:improt 抓遠端    url放進data 下面data是atibu 沒特別獎scope都是page context-->
<c:import url="http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx" var="data" />


 <%
   String strJSON=(String)pageContext.getAttribute("data");
 
  // out.print(strJSON);
     
    JSONArray root=new JSONArray(strJSON);
  // out.print(root.length());

	
	for (int i=0; i<root.length(); i++){
		JSONObject objData = root.getJSONObject(i);
		String name = objData.getString("Name");
		String tel = objData.getString("Tel");
		String address = objData.getString("Address");
		
		out.println(name +":" + tel + ":" + address + "<br>");
		
	}

 %>

</body>
</html>