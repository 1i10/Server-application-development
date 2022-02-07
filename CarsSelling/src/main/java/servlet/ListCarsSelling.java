package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.CarSelling;
import db.CarsSellingDB;

/**
 * Servlet implementation class ListCarsSelling
 */
@WebServlet("/")
public class ListCarsSelling extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CarSelling> carsSelling = null;
		try {
			carsSelling = CarsSellingDB.listSellingPositions();
			
			request.setAttribute("carsSelling", carsSelling);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListCarsSelling.jsp");
	        dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
