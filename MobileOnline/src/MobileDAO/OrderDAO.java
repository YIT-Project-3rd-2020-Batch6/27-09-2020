package MobileDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MobileModel.CartModel;
import MobileModel.OrderModel;
import MobileModel.ProductModel;

public class OrderDAO {
	private static Connection con; 
	 private static PreparedStatement stmt;
	  
	public static void getConnection()
	  {	 	
		  String JdbcURL = "jdbc:mysql://localhost:3306/mobiledb?" + "autoReconnect=true&useSSL=false";
	      String Username = "root";
	      String password = "";
	       con = null;      
	      try 
	      {
	    	 Class.forName("com.mysql.jdbc.Driver");   // Driver should be registered
	    	 // con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test1","root","");  
	         con = DriverManager.getConnection(JdbcURL, Username, password);
	         
	      } 
	      catch (Exception e) 
	      {
	         e.printStackTrace();
	      }
		   
		 
	  }
	  public static void closeConnection()
	  {
		  try{
			  if(con.isClosed()==false)
		          con.close();   // closing the connection
		  }
		  catch(Exception e)
		  { e.printStackTrace();	 }
	  } 
	  
	  public static boolean addCart(CartModel cart)
	  {
	 	 boolean status=false;	
	 	 System.out.println("test");
	 	 String sql="insert into mobiledb.cart values(?,?,?,?)";
	 	try {
	 		getConnection();
	 		stmt=con.prepareStatement(sql);
	 		stmt.setInt(1, cart.getCid());
	 		stmt.setInt(2, cart.getPid());
	 		stmt.setInt(3, cart.getQuantity());
	 		stmt.setString(4, cart.getUserid());
	 		int nor=stmt.executeUpdate();
	 		System.out.println("sql:"+stmt.toString());
	 		closeConnection();
	 		   if(nor>0)
	 			   return true;
	 		   else
	 			   return false;
	 	  }
	 	  catch(SQLException e)
	 	  {
	 	  e.printStackTrace();
	 	  return false;
	 	  }
	 	  catch(Exception e)
	 	  {
	 	  e.printStackTrace();
	 	  return false;
	 	  }
	  }
	  
	  public static int getCartId()
	  {
		  String sql="select max(cid) from cart";
		  try
		  {
			  getConnection();
			  stmt=con.prepareStatement(sql);
			  ResultSet rs=stmt.executeQuery();
			  System.out.println("sql:"+stmt.toString());
			  int cartid=0;
			  if(rs.next())
			  {
				 cartid=rs.getInt(1);
			  }
			  System.out.println(cartid);
			  closeConnection();
			  return cartid;
		  }
		  catch(SQLException e)
		  {	  e.printStackTrace();	 return 0; }
		  catch(Exception e)
		  {	  e.printStackTrace();	 return 0; }  	  
		  
	  }
	  public static int getOrderId()
	  {
		  String sql="select max(oid) from orderm";
		  try
		  {
			  getConnection();
			  stmt=con.prepareStatement(sql);
			  ResultSet rs=stmt.executeQuery();
			  System.out.println("sql:"+stmt.toString());
			  int orderid=0;
			  if(rs.next())
			  {
				 orderid=rs.getInt(1);
			  }
			  System.out.println(orderid);
			  closeConnection();
			  return orderid;
		  }
		  catch(SQLException e)
		  {	  e.printStackTrace();	 return 0; }
		  catch(Exception e)
		  {	  e.printStackTrace();	 return 0; }  	  
		  
	  }
	  
	  public static String getAddress(String userid)
	  {
		  
		  String sql="select address from register where userid=?";
		  try
		  {
			  getConnection();
			  stmt=con.prepareStatement(sql);
			  stmt.setString(1, userid);
			  ResultSet rs=stmt.executeQuery();
			  System.out.println("sql:"+stmt.toString());
			  String addr=null;
			  if(rs.next())
			  {
				 addr=rs.getString(1);
			  }
			  System.out.println(addr);
			  closeConnection();
			  return addr;
			  
		  }
		  catch(SQLException e)
		  {	  e.printStackTrace();	 return null; }
		  catch(Exception e)
		  {	  e.printStackTrace();	 return null; }  	  
		  
	  }
	  
	  public static boolean addOrder(OrderModel od)
	  {
		  String sql="insert into orderm values(?,?,?,?,?,?,?,?,?,?)";
		  try
		  {
			 getConnection();
			 stmt=con.prepareStatement(sql);
			 stmt.setInt(1, od.getOid());
			 stmt.setInt(2, od.getPid());
			 stmt.setInt(3, od.getCid());
			 stmt.setString(4, od.getUserid());
			 stmt.setInt(5, od.getPrice());
			 stmt.setString(6, od.getOdate());
			 stmt.setString(7, null);
			 stmt.setString(8,null);
			 stmt.setString(9, od.getAddress());
			 stmt.setString(10, null);
			 int nor=stmt.executeUpdate();
		 		System.out.println("sql:"+stmt.toString());
		 		closeConnection();
		 		   if(nor>0)
		 			   return true;
		 		   else
		 			   return false;
			 
		  }
		  catch(SQLException e)
	 	  {
	 	  e.printStackTrace();
	 	  return false;
	 	  }
	 	  catch(Exception e)
	 	  {
	 	  e.printStackTrace();
	 	  return false;
	 	  }
	  }
	  
	  
}
