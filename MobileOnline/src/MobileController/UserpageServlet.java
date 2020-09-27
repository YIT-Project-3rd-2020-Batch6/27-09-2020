package MobileController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MobileDAO.ProductDAO;
import MobileModel.ProductModel;

/**
 * Servlet implementation class UserpageServlet
 */
@WebServlet("/UserpageServlet")
public class UserpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserpageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd=null;
		ArrayList<ProductModel> allProducts;
		String val="";
		ArrayList<String> allAndriod=ProductDAO.getAllAndriod();
		request.setAttribute("allandriod", allAndriod);
		ArrayList<String> allIos=ProductDAO.getAllIos();
		request.setAttribute("allios", allIos);
		ArrayList<String> allPro= ProductDAO.getAllProcessor();
		request.setAttribute("allpro", allPro);
		ArrayList<String> allRam=ProductDAO.getAllRam();
		request.setAttribute("allram", allRam);
		
		if(request.getParameter("search")!=null)
		{
			String brand1 = request.getParameter("andriod");
			String brand2 = request.getParameter("ios");
			String processor=request.getParameter("pro");
			String ram=request.getParameter("ram");
			if(brand1.equals("select"))
			{
				allProducts= ProductDAO.getProducts(brand2, processor, ram);
				request.setAttribute("allProducts", allProducts);
				
			}
			else if(brand2.equals("select"))
			{
				allProducts= ProductDAO.getProducts(brand1, processor, ram);
				request.setAttribute("allProducts", allProducts);
			}
			if(request.getParameter("keyword")!="")
			{
			
				String keyword=request.getParameter("keyword");
				System.out.println("keyword="+keyword);
				allProducts= ProductDAO.getProductsByKeyword(keyword);
				request.setAttribute("allProducts", allProducts);
			}
			}
		rd=request.getRequestDispatcher("main.jsp");		    
 	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
