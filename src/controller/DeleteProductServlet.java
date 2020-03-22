package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.data.ProductIO;
import music.models.Product;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Pass product and pass attributes to confirmDelete.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String productCode = (String)request.getParameter("productCode");
		Product product = ProductIO.getProduct(productCode);
		request.setAttribute("product", product);
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/confirmDelete.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Remove product from list if confirmed, forward to productMaint.jsp
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String productCode = (String)request.getParameter("productCode");
		
		if(request.getParameter("confirmedDelete").equals("yes")) {
			ProductIO.deleteProduct(productCode);
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/productMaint.jsp").forward(request, response);
		
		
	}

}
