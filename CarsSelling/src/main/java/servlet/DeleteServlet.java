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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int code = Integer.parseInt(request.getParameter("code"));
            
            CarSelling delPosition = new CarSelling(code);	
			CarsSellingDB.deletePosition(delPosition);
			response.sendRedirect(request.getContextPath()+"/ListCarsSelling");
        }
        catch(Exception ex) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/notFound.jsp");
            dispatcher.forward(request, response);  
        }
	}

}
