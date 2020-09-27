<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="MobileModel.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link  rel="stylesheet" link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" >
</head>
<body>
<form action="UserpageServlet" method="get">
<div class="header">
<div class="menu-bar">
<ul>
<li class="active"><a href="#"><i class="fa fa-home" aria-hidden="true"></i>Home</a></li>
<li>
<p>Andriod</P>
		<select id="andriod" name="andriod">
		<option value="select">Select</option>
		<% String list2="";
            if(request.getAttribute("allandriod")!=null)
            	
            {
            	
            	ArrayList<String> allAndriod=(ArrayList<String>)request.getAttribute("allandriod");
            	for (String val: allAndriod)
            	{
            		list2=list2+"<option>"+val+"</option>";
            	}
            }
            out.println(list2);
            		
            %>
			</select>


			
 </li>

 <li>

			<p>IOS</P>
		<select id="ios" name="ios">
		<option value="select">Select</option>
		<% String list3="";
            if(request.getAttribute("allios")!=null)
            	
            {
            	
            	ArrayList<String> allIos=(ArrayList<String>)request.getAttribute("allios");
            	for (String val: allIos)
            	{
            		list3=list3+"<option>"+val+"</option>";
            	}
            }
            out.println(list3);
            		
            %>
			</select>
			
 </li>
<li>
	    <p>Processor</P>
		<select id="pro" name="pro">
		<option value="select">Select</option>
		<% String list="";
            if(request.getAttribute("allpro")!=null)
            	
            {
            	
            	ArrayList<String> allPro=(ArrayList<String>)request.getAttribute("allpro");
            	for (String val: allPro)
            	{
            		list=list+"<option>"+val+"</option>";
            	}
            }
            out.println(list);
            		
            %>
			</select>


	 </li>

<li>
<p>Ram</P>
		<select id="ram" name="ram">
		 <option value="select">Select</option>
		 <% String list1="";
            if(request.getAttribute("allram")!=null)
            	
            {
            	
            	ArrayList<String> allRam=(ArrayList<String>)request.getAttribute("allram");
            	for (String val: allRam)
            	{
            		list1=list1+"<option>"+val+"</option>";
            	}
            }
            out.println(list1);
            		
            %>
		
			</select>
	 </li>
	 

<li><a href="cart.jsp"><i class="fa fa-shopping-cart" aria-hidden="true"></i>Cart</a></li>
<li><a href="#"><i class="fa fa-truck" aria-hidden="true"></i> Order</a></li>
<li><a href="login.jsps"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
	 <div class="search-form">
	 <input type="text" name="keyword" placeholder="Search for Mobiles" />

	 <input type="submit" name="search" value="Search">
</div>>

</ul>

</div>
<h1>MobileX Store</h1>
<div class="show">
<div class="table-box">
<div class="table-row">


<table id="products">
 
    <th>pid</th>
    <th>pname</th>
    <th>category</th>
    <th>brand</th>
    <th>ram</th>
    <th>rom</th>
    <th>processor</th>
    <th>battery</th>
    <th>price</th>
    <th>descrption</th>
    </div>
</div>
  <tr>
  <td>
  

  
 <%
 
 String record="";
 String userid = (String) session.getAttribute("userid");
			 
 if(request.getAttribute("allProducts")!=null)
 { 
  ArrayList<ProductModel> allProduct=(ArrayList<ProductModel>)request.getAttribute("allProducts");   
   for(ProductModel s: allProduct)
    {  
 	   record=record+"<tr>";
 	   record=record+"<td>"+s.getPid()+"</td><td>"+s.getPname()+"</td><td>"+s.getCategory()+"</td><td>"+s.getBrand()+"</td><td>"+s.getRam()+"</td><td>"+s.getRom()+"</td><td>"+s.getProcessor()+"</td><td>"+s.getBattery()+"</td><td>"+s.getPrice()+"</td><td>"+s.getDescrptn()+"</td>"; 	   
 	   record=record+"<td><input type=Radio name=choose value='"+s.getPid()+"'></td>";
 	   record=record+"<td><a href='CartServlet?oper=order&pid="+s.getPid()+"&userid="+userid+"'>Order</a></td>";
 	   record=record+"</tr>";
    }
 }
 out.println(record);
 
 %>
 </td>
  </tr>
 
  
</table>
<br><br>



</div>
</form>
</body>
</html>