package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.CarSelling;
import db.CarsSellingDB;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		try {
            int code = Integer.parseInt(request.getParameter("code"));
            CarSelling position = CarsSellingDB.selectPosition(code);
     
            if(position != null) {
                request.setAttribute("position", position);
                dispatcher = request.getRequestDispatcher("/update.jsp");
                dispatcher.forward(request, response);
            }
            else {
            	dispatcher = request.getRequestDispatcher("/notFound.jsp");
                dispatcher.forward(request, response);
            }
        }
        catch(Exception ex) {
        	dispatcher = request.getRequestDispatcher("/notFound.jsp");
            dispatcher.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int code = Integer.parseInt(request.getParameter("code"));
            String manufacturer = request.getParameter("manufacturer");
         	String model = request.getParameter("model");
         	String color = request.getParameter("color");
         	String transmission = request.getParameter("transmission");
         	String body_type = request.getParameter("body_type");
         	float price = Float.parseFloat(request.getParameter("price"));
         	
            CarSelling editPosition = new CarSelling(code, manufacturer, model, color, transmission,
             		body_type, price);	
			CarsSellingDB.updatePosition(editPosition);
			response.sendRedirect(request.getContextPath()+"/ListCarsSelling");
        }
        catch(Exception ex) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/notFound.jsp");
            dispatcher.forward(request, response);  
        }
	}

}
