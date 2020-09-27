<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart form</title>
<link rel="stylesheet" type="text/css" href="./css/cart.css">
<style >
button {
    border:none;
	outline:none;
	height:40px;
	background:#fb2525;
	color:#fff;
	font-size:18px;
	border-radius:3px;
	font-size:16px;
	font-family:sans-serif;
	width:400px;
}
button :hover {
	cursor:pointer;
	background:#ffc107;
	color:#000;

}
</style>
<body>
<%@ page import="MobileModel.*" %>
  <%@ page import="java.util.*" %>
  <%@ page import="MobileDAO.*" %>
<%
ProductModel temp=new ProductModel();
if(request.getAttribute("product")!=null)
temp=(ProductModel)request.getAttribute("product");	
System.out.println(temp.getPid()+" "+temp.getPname());
%>
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
   <div class="cart">
	  <h1>Cart</h1>
		 <form action="CartServlet" method=get>
			<p>Product-id</P>
			<input type="text" name="pid" id="name"  readonly value='<% out.println(temp.getPid()); %>'>
			<p>Cart-id</P>
			<input type="text" name="cid" id="name" readonly value='<% int cid=0;
			cid=OrderDAO.getCartId();
			out.println(cid+1); %>'>
			<p>Quantity</P>
			<input type="text" name="quantity" id="name" placeholder="Enter Quantity" >
			<p>Name</P>
        	<input type="text" name="pname" id="name" readonly value='<% out.println(temp.getPname()); %>'>
        	<button type="submit" name="sub" value="sub">Add to cart</button>
        	<button type="submit" name="order" value="order" formaction="OrderServlet">Order</button>
	       
			
	  </form>
	  
      </div>

</body>
</head>
</html>