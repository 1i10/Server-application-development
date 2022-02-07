package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.CarSelling;
import db.CarsSellingDB;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/insert.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	String manufacturer = request.getParameter("manufacturer");
         	String model = request.getParameter("model");
         	String color = request.getParameter("color");
         	String transmission = request.getParameter("transmission");
         	String body_type = request.getParameter("body_type");
         	float price = Float.parseFloat(request.getParameter("price"));
         	
            CarSelling newPosition = new CarSelling(manufacturer, model, color, transmission,
             		body_type, price);
        		
			CarsSellingDB.insertPosition(newPosition);
			response.sendRedirect(request.getContextPath()+"/ListCarsSelling");
		} catch (SQLException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/insert.jsp");
	        dispatcher.forward(request, response);
		}
	}

}
