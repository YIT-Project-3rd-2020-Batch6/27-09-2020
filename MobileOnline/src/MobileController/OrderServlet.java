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
import MobileModel.OrderModel;
import MobileModel.ProductModel;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		
		if(Integer.parseInt(request.getParameter("pid"))!=0)
		{
			int pid1=Integer.parseInt(request.getParameter("pid"));
			request.setAttribute("pid", pid1);
			int cid1=Integer.parseInt(request.getParameter("cid"));
			request.setAttribute("cid", cid1);
			rd=request.getRequestDispatcher("order.jsp");
	    	rd.forward(request, response);
		}
		
		if(request.getParameter("sub")!=null)
		{
			System.out.println("test100");
			int oid=Integer.parseInt(request.getParameter("oid"));
			pid=Integer.parseInt(request.getParameter("pid"));
			int cid=Integer.parseInt(request.getParameter("cid"));
			String userid=request.getParameter("userid");
			String address=request.getParameter("address");
			String date=request.getParameter("date");
			OrderModel temp1=new OrderModel();
			temp1.setOid(oid);
			temp1.setPid(pid);
			temp1.setCid(cid);
			temp1.setUserid(userid);
			temp1.setAddress(address);
			temp1.setOdate(date);
			boolean  status=false;
			status=OrderDAO.addOrder(temp1);
			if(status==true)
			{
			rd=request.getRequestDispatcher("order.jsp");
		    rd.forward(request, response);
			}
			else
			{
			rd=request.getRequestDispatcher("main.jsp");
		    rd.forward(request, response);
			}
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
