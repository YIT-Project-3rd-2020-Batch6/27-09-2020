<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Product</title>
<link rel="stylesheet" type="text/css" href="./css/delete.css">
</head>
<body>
<a href="admin.jsp" >
      <button style="border:none;
	                outline:none;
	                 height:40px;
	                 background:#fb2525;
	                 color:#fff;
	                 font-size:18px;
					 width:100px;
	                 border-radius:3px;
					 cursor:pointer;
	                ;">Back</button>
        </a>
 <%@ page import="MobileModel.*" %>
  <%@ page import="java.util.*" %>
<%
ProductModel temp=new ProductModel();
if(request.getAttribute("product")!=null)
temp=(ProductModel)request.getAttribute("product");	
System.out.println(temp.getPid()+" "+temp.getPname());
%>
<%
if(request.getAttribute("successmsg")!=null)
{  String msg=(String)request.getAttribute("successmsg");
	out.println("<font color=green size=5>"+msg+"</font>");
}
else if(request.getAttribute("errorsmsg")!=null)
{
String errmsg=(String)request.getAttribute("successmsg");
out.println("<font color=red size=5>"+errmsg+"</font>");
}
%>
 <div class="delete-product-form">
 <h1>Delete Product</h1>
<form method=get action="DeleteServlet"><p> Pid </p>
 <input type=text size=10 name="pid" id="name" readonly value='<% out.println(temp.getPid()); %>'><br><br>
 <p> Pname</p>
  <input type=text size=10 name="pname"   id="name" value='<% out.println(temp.getPname()); %>'><br><br>
 <p> Category</p>
  <input type="text" size=10 name="category"  id="name"  value='<% out.println(temp.getCategory()); %>'><br><br>
 <p> Brand </p>
  <input type=text size=10 name="brand"  id="name" value='<% out.println(temp.getBrand()); %>'><br><br>
 <p> Ram</p>
  <input type=text size=10 name="ram"  id="name" value='<% out.println(temp.getRam()); %>'><br><br>
 <p> Rom</p>
  <input type=text size=10 name="rom"  id="name" value='<% out.println(temp.getRom()); %>'><br><br>
 <p> Processor</p>
  <input type=text size=10 name="processor"  id="name" value='<% out.println(temp.getProcessor()); %>'><br><br>
 <p> Battery</p>
  <input type=text size=10 name="battery"  id="name" value='<% out.println(temp.getBattery()); %>'><br><br>
 <p> Price</p>
 <input type=text size=10 name="price" id="name" value='<% out.println(temp.getPrice()); %>'><br><br>
 <p> Descrptn</p>
  <input type=text size=10 name="descrptn"  id="name" value='<% out.println(temp.getDescrptn()); %>'><br><br>
   <input type=submit name="confirmdelete" value="confirm to Delete">
  </form>
</body>
</html>