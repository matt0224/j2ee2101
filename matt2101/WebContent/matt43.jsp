<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%//43有問題
  String x=request.getParameter("x");
  String y=request.getParameter("y");
  String op=request.getParameter("op");
  int intX, intY;
  String result="";
  //int result=0;
  if(x !=null && y!=null){
	 intX=Integer.parseInt(x);
	 intY=Integer.parseInt(y);
	 switch(op){
	 case"1":result=(intX+intY)+"";break;
	 case"2":result=(intX-intY)+"";break;
	 case"3":result=(intX*intY)+"";break;
	 case"4"://:result=(intX/intY)+"";break;
	   int temp1=intX / intY;
	   int temp2=intX % intY;
	   result=temp1+"..."+temp2;
	   break;
	   
	 }
  }else{
	  op="";
	  intX=intY=0;
	  
  }

%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form >
	<input type='text' name='<%= intX%>' />
	<select name='op'>
	   <option value='1'<%= (op.equals("1")?"selected":"") %>>+</option>
	   <option value='2'<%= (op.equals("2")?"selected":"") %>>-</option>
	   <option value='3'<%= (op.equals("3")?"selected":"") %>>*</option>
	   <option value='4'<%= (op.equals("4")?"selected":"") %>>/</option>
	
	</select>
	<input type='text' name='<%= intY%>' />
	<input type='submit' value='=' />
	<%= result %>
</form>
</body>
</html>