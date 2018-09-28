package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;

/**
 * Servlet implementation class addCarServlet
 */
@WebServlet("/addCarServlet")
public class addCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String yearString = request.getParameter("year");
		int year = 0000;
		try{ year = Integer.parseInt(request.getParameter("year"));} catch (Exception e) {}
		
		if (make.equals("") && model.equals("") && year == 0) {} else {
			Car car = new Car(make, model, year);
			CarDAO dao = new CarDAO();
			dao.insertItem(car);
		}
		
		getServletContext().getRequestDispatcher("/addCar.html").forward(request, response);
	}

}
