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
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		}
		
		if(request.getParameter("productCode") != null) {
			String productCode = (String)request.getParameter("productCode");
			Product product = ProductIO.getProduct(productCode);
			request.setAttribute("product", product);
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/editProduct.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		System.out.println(request.getParameter("AddOrUpdate"));
		
		
		// create new updated product object
		Product updatedProduct = new Product();
		updatedProduct.setCode(request.getParameter("productCode"));
		updatedProduct.setDescription(request.getParameter("productDescription"));
		updatedProduct.setPrice(Double.parseDouble(request.getParameter("productCost")));

		if(((String)request.getParameter("AddOrUpdate")).equals("Add")) {
			// add session products
			ProductIO.insertProduct(updatedProduct);
		} else {
			// update session products
			ProductIO.updateProduct(updatedProduct);
		}
		
		request.setAttribute("products", ProductIO.getProducts());
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/productMaint.jsp").forward(request, response);
		
	}

}
