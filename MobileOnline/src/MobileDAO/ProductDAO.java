package MobileDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MobileModel.ProductModel;
import MobileModel.RegisterModel;



public class ProductDAO {
	
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
	  public static boolean addProduct(ProductModel product)
	  {
	 	 boolean status=false;	
	 	 System.out.println("test");
	 	 String sql="insert into mobiledb.product values(?,?,?,?,?,?,?,?,?,?)";
	 	try {
	 		getConnection();
	 		stmt=con.prepareStatement(sql);
	 		stmt.setInt(1, product.getPid());
	 		stmt.setString(2, product.getPname());
	 		stmt.setString(3, product.getCategory());
	 		stmt.setString(4, product.getBrand());
	 		stmt.setString(5, product.getRam());
	 		stmt.setString(6, product.getRom());
	 		stmt.setString(7, product.getProcessor());
	 		stmt.setString(8, product.getBattery());
	 		stmt.setInt(9, product.getPrice());
	 		stmt.setString(10, product.getDescrptn());
	 		System.out.println("sql:"+stmt.toString());
	 		int nor=stmt.executeUpdate();
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
	 		
	  
  public static ArrayList<String> getAllBrand()
  {
  ArrayList<String> allbrand=new ArrayList<String>();	  
  try
  {
    getConnection();
    stmt=con.prepareStatement("select distinct brand from product");       
    ResultSet rs=stmt.executeQuery();  
    while(rs.next())
	  {  
	    	allbrand.add(rs.getString(1))	; 		
	  }  
     closeConnection();	 
     return allbrand;
  }
  catch(SQLException e)
  {	  e.printStackTrace();	 return null; }
  catch(Exception e)
  {	  e.printStackTrace();	 return null; }  	  
}
  public static ArrayList<String> getAllAndriod()
  {
	  String category="andriod";
  ArrayList<String> allandriod=new ArrayList<String>();	  
  try
  {
    getConnection();
    String sql="select distinct brand from product where category=?";
    stmt=con.prepareStatement(sql);  
    stmt.setString(1, category);
    ResultSet rs=stmt.executeQuery();  
    System.out.println("sql:"+stmt.toString());
    while(rs.next())
	  {  
	    	allandriod.add(rs.getString(1))	; 		
	  }  
     closeConnection();	 
     return allandriod;
  }
  catch(SQLException e)
  {	  e.printStackTrace();	 return null; }
  catch(Exception e)
  {	  e.printStackTrace();	 return null; }  	  
}
  public static ArrayList<String> getAllIos()
  {
  ArrayList<String> allios=new ArrayList<String>();	  
  try
  {
    getConnection();
    String category="ios";
    stmt=con.prepareStatement("select distinct brand from product where category=?");  
    stmt.setString(1, category);
    ResultSet rs=stmt.executeQuery();  
    while(rs.next())
	  {  
	    	allios.add(rs.getString(1))	; 		
	  }  
     closeConnection();	 
     return allios;
  }
  catch(SQLException e)
  {	  e.printStackTrace();	 return null; }
  catch(Exception e)
  {	  e.printStackTrace();	 return null; }  	  
}
  
  public static ArrayList<String> getAllProcessor()
  {
  ArrayList<String> allpro=new ArrayList<String>();	  
  try
  {
    getConnection();
    String sql="select distinct processor from product";
    stmt=con.prepareStatement(sql);  
    ResultSet rs=stmt.executeQuery();  
    System.out.println("sql:"+stmt.toString());
    while(rs.next())
	  {  
	    	allpro.add(rs.getString(1))	; 		
	  }  
     closeConnection();	 
     return allpro;
  }
  catch(SQLException e)
  {	  e.printStackTrace();	 return null; }
  catch(Exception e)
  {	  e.printStackTrace();	 return null; }  	  
}
  public static ArrayList<String> getAllRam()
  {
  ArrayList<String> allram=new ArrayList<String>();	  
  try
  {
    getConnection();
    String sql="select distinct ram from product";
    stmt=con.prepareStatement(sql);  
    ResultSet rs=stmt.executeQuery();  
    System.out.println("sql:"+stmt.toString());
    while(rs.next())
	  {  
	    	allram.add(rs.getString(1))	; 		
	  }  
     closeConnection();	 
     return allram;
  }
  catch(SQLException e)
  {	  e.printStackTrace();	 return null; }
  catch(Exception e)
  {	  e.printStackTrace();	 return null; }  	  
}
  public static ArrayList<ProductModel> getProductssByBrand(String brand)
  {
	  ArrayList <ProductModel> products=new ArrayList<ProductModel>();
	  ProductModel temp; 
	  	  
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("select pid,pname,category,ram,rom,processor,battery,price,descrptn from product where brand=?"); 
      stmt.setString(1, brand);
	  ResultSet rs=stmt.executeQuery();  
	 // System.out.println(branch);
	  while(rs.next())
		  {  		   
		  temp=new ProductModel(rs.getInt(1), rs.getString(2),rs.getString(3),brand,rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));	
		  products.add(temp); 		  
		  
		  }  
	     closeConnection();	 
	     return products;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return null; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return null; }  	  
  }
  
  public static ArrayList<ProductModel> getProducts(String brand, String processor, String ram)
  {
	  ArrayList <ProductModel> products=new ArrayList<ProductModel>();
	  ProductModel temp; 
	  	  
	  try
	  {
	  getConnection();
	  String sql="select pid,pname,category,ram,rom,processor,battery,price,descrptn from product where brand=? and processor=? and ram=?";
      stmt=con.prepareStatement(sql); 
      stmt.setString(1, brand);
      stmt.setString(2, processor);
      stmt.setString(3, ram);
	  ResultSet rs=stmt.executeQuery();  
	  System.out.println("sql:"+stmt.toString());
	  while(rs.next())
		  {  		   
		  temp=new ProductModel(rs.getInt(1), rs.getString(2),rs.getString(3),brand,rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));	
		  products.add(temp); 		  
		  
		  }  
	     closeConnection();	 
	     return products;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return null; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return null; }  	  
  }
  
  public static ProductModel getProductsByPid(int pid)
  {
	  ProductModel temp=null;	  	  
	  try
	  {
	  getConnection();
	  String sql="select pid,pname,category,brand,ram,rom,processor,battery,price,descrptn from product where pid=?";
      stmt=con.prepareStatement(sql);
      stmt.setInt(1, pid);
	  ResultSet rs=stmt.executeQuery(); 
	  System.out.println("sql:"+stmt.toString());
	  boolean flag=false;
	 // System.out.println(brand);
	  if(rs.next())
		  {  		
		//System.out.println(rs.getInt(1)+ rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));

		  temp=new ProductModel(pid, rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10));	
		  flag=true;
		  }  
	     closeConnection();	 
	     if(flag==true)
	       return temp;
	     else
	    	 return null;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return null; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return null; }  	  
  }
  
  public static ArrayList<ProductModel> getProductsByKeyword(String keyword)
  {

	  ArrayList <ProductModel> products=new ArrayList<ProductModel>();
	  ProductModel temp=null;	
	  boolean flag=false;
	  ArrayList <ProductModel> p=new ArrayList<ProductModel>();
	  System.out.println("key:"+keyword);
	  if(keyword=="")
	  {
		  return p=null;
	  }
	  else if(keyword!="")
	  { try {
	  getConnection();
	  String sql="select pid,pname,category,brand,ram,rom,processor,battery,price,descrptn from product where descrptn like ?";
      stmt=con.prepareStatement(sql);
      stmt.setString(1, "%"+keyword+"%");
	  ResultSet rs=stmt.executeQuery(); 
	  System.out.println("sql:"+stmt.toString());
	  while(rs.next())
		  {
		  temp=new ProductModel(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10));	
		  products.add(temp);
		  flag=true;
		  }  
	     closeConnection();	 
	     if(flag==true)
	       return p= products;
	     else
	    	 return p= null;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return null; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return null; }  
  }
	  return p;
  }
  
  public static boolean EditProductByPid(ProductModel temp)
  {
	 	  	  
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("update product set pname=?,category=?,brand=?,ram=?,rom=?,processor=?,battery=?,price=?,descrptn=? where pid=?"); 
      stmt.setInt(10, temp.getPid());
      stmt.setString(1, temp.getPname());
      stmt.setString(2, temp.getCategory());
      stmt.setString(3, temp.getBrand());
      stmt.setString(4, temp.getRam());
      stmt.setString(5, temp.getRom());
      stmt.setString(6, temp.getProcessor());
      stmt.setString(7, temp.getBattery());
      stmt.setInt(8, temp.getPrice()); 
      stmt.setString(9,  temp.getDescrptn());
	  System.out.println(stmt.toString());
	  boolean flag=false;
	  int nor=stmt.executeUpdate();
	    closeConnection();	 
	     if(nor>0)
	       return true;
	     else
	    	 return false;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return false; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return false; }  	  
  }
  public static boolean deleteProductsByPid(int pid)
  {
	  try
	  {
	  getConnection();
      stmt=con.prepareStatement("delete from product where pid=?"); 
      
      stmt.setInt(1, pid);
    
	  System.out.println(stmt.toString());
	  boolean flag=false;
	  int nor=stmt.executeUpdate();
	    closeConnection();	 
	     if(nor>0)
	       return true;
	     else
	    	 return false;
	  }
	  catch(SQLException e)
	  {	  e.printStackTrace();	 return false; }
	  catch(Exception e)
	  {	  e.printStackTrace();	 return false; }  
	  
  }

}
