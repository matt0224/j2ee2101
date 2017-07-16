<%@ tag  dynamic-attributes="product"%>
<%@ attribute name="user" rtexprvalue="true"%>
<%@ tag import="java.util.*" %>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  //dynamic運作原理用 KV KV 先   GETCLASS是把東西還回原名
   out.println("<h1>Brad Big Company</h1>");

		HashMap<String,String> ps = 
			(HashMap<String,String>)jspContext.getAttribute("product");
		
		if (ps.containsKey("name")){
			out.println(ps.get("name"));	
		}
		
//		out.println((String)ps[0].key);
  
%>
<table  border="1" width="100">
  <tr>
    <th>Item</th>
    <th>Value</th>
  </tr>
  
  <%
  
       if(ps==null){
    	   out.print("XX");
       }
     //  out.print((string)ps[0].key);
  
  %>
  
   <c:forEach var="prod" items="${product }">
   <tr>
    <td>${prod.key }</td>
    <td>${prod.value }</td>
  </tr>

   </c:forEach>
  
</table>
