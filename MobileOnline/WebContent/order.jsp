<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/order.css">
<title>Place Order</title>
</head>

<%@ page import="MobileModel.*" %>
  <%@ page import="java.util.*" %>
  <%@ page import="MobileDAO.*" %>
  <%
  ProductModel temp=new ProductModel();
if(request.getAttribute("product")!=null)
temp=(ProductModel)request.getAttribute("product");	
System.out.println(temp.getPid()+" "+temp.getPname());
%>
<body>
<a href="main.jsp" >
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
   <div class="order">
	  <h1>Place Order</h1>
	  <form>
		 <form action="OrderServlet" method="get">
		    <p>Order-id</P>
			<input type="text" name="oid" id="name" placeholder="Order-id" readonly value='<% int oid=0;
		    oid=OrderDAO.getOrderId();
		    out.println(oid+1);
		    %>'>
			<p>Product-id</P>
			<input type="text" name="pid" id="name" placeholder="Product-id" readonly value='<% int pid=Integer.parseInt(request.getParameter("pid")); 
			out.println(pid);
			%>'>
			<p>Cart-id</P>
			<input type="text" name="cid" id="name" placeholder="Cart-id" readonly value='<% int cid=Integer.parseInt(request.getParameter("cid"));
			out.println(cid);
			%>'>
			<p>Name</P>
			<input type="text" name="userid" id="name" placeholder="Name" readonly value='<% HttpSession session1=request.getSession(false);
					String userid=(String) session1.getAttribute("userid"); 
					out.println(userid);%>'>
			<p>Address</P>
        	<input type="text" name="address" id="name" placeholder=Address readonly value='<% String addr="";
			addr=OrderDAO.getAddress(userid);
			out.println(addr);
			%>'>
        	<label for="date">Date</label>
            <input type="date"  onload="getDate()" class="form-control" id="date" name="date">
             
	        <input type ="submit" name="sub" id="sub" value="Add">
			
	  </form>
	  
			
	  </form>
	  
      </div>

</body>
</html>