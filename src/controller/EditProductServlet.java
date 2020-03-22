package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import music.data.ProductIO;
import music.models.Product;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.isNew()) {
			session.setAttribute("products", ProductIO.getProducts());
		}
		
		String productCode = (String)request.getParameter("productCode");
		Product product = ProductIO.getProduct(productCode);
		request.setAttribute("product", product);
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/editProduct.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
