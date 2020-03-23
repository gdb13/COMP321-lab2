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
import music.models.CartEntry;
import music.models.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/Cart")
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
		
		HttpSession session = request.getSession();
		if(session.isNew()) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		}
		
		@SuppressWarnings("unchecked")
		List<CartEntry> cartEntries = (List<CartEntry>) session.getAttribute("cart");
		
		request.setAttribute("cart", cartEntries);
		request.setAttribute("cartTotal", getCartTotal(cartEntries));
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<CartEntry> cartEntries = (List<CartEntry>) session.getAttribute("cart");
		
		// increment cart item by one if found
		Boolean itemFound = false;
		for(CartEntry ce:cartEntries) {
			if(ce.getProduct().getCode().equals(request.getParameter("productCode"))) {
				ce.setQty(ce.getQty()+1);
				itemFound = true;
			}
		}
		
		// cart item not previously added; create cart entry and add to cart
		if(!itemFound) {
			Product product = ProductIO.getProduct(request.getParameter("productCode"));
			CartEntry cartEntry = new CartEntry(product, 1);
			cartEntries.add(cartEntry);
		}
		
		session.setAttribute("cart", cartEntries);
		request.setAttribute("cartTotal", getCartTotal(cartEntries));
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(request, response);
	}
	
	
	private double getCartTotal(List<CartEntry> cartEntries) {

		double cartTotal = 0;
		for(CartEntry ce:cartEntries) {
			cartTotal = cartTotal + ce.getProduct().getPrice();
		}
		
		return cartTotal;
	}

}
