package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;

/**
 * Servlet implementation class editCarServlet
 */
@WebServlet("/editCarServlet")
public class editCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDAO dao = new CarDAO();
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int year = 0000;
		
		try{ year = Integer.parseInt(request.getParameter("year"));} catch (Exception e) {}
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		dao.updateMake(tempId, make);
		dao.updateModel(tempId, model);
		dao.updateYear(tempId, year);
		
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}

}
