package MobileController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MobileDAO.OrderDAO;
import MobileDAO.ProductDAO;
import MobileModel.CartModel;
import MobileModel.ProductModel;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid;
		RequestDispatcher rd=null;
		System.out.println("test13");
		ProductModel temp=new ProductModel();
		if(request.getParameter("oper")!=null)
		{
			if(request.getParameter("oper").equals("order"))
			{
				
				pid=Integer.parseInt(request.getParameter("pid"));					
			    temp.setPid(pid);
			    temp=ProductDAO.getProductsByPid(pid);
			    if(temp!=null)
			    {
			    	
			    	request.setAttribute("product", temp);
			    	rd=request.getRequestDispatcher("cart.jsp");
			    	rd.forward(request, response);	
			    	
			    }		    
			}
		}
		
		if(request.getParameter("sub")!=null)
		{
			System.out.println("test100");
			pid=Integer.parseInt(request.getParameter("pid"));
			int cid=Integer.parseInt(request.getParameter("cid"));
			int qty=Integer.parseInt(request.getParameter("quantity"));
			HttpSession session=request.getSession(false);
			String userid=(String) session.getAttribute("userid");
			CartModel temp1=new CartModel();
			temp1.setPid(pid);
			temp1.setCid(cid);
			temp1.setQuantity(qty);
			temp1.setUserid(userid);
			boolean  status=false;
			status=OrderDAO.addCart(temp1);
			if(status==true)
			 	request.setAttribute("successmsg", "Added to cart");
			else
				request.setAttribute("errormsg", "Not updated");			 
			rd=request.getRequestDispatcher("main.jsp");
    	    rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
