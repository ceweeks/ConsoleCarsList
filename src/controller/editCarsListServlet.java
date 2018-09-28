package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;

/**
 * Servlet implementation class editCarsListServlet
 */
@WebServlet("/editCarsListServlet")
public class editCarsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCarsListServlet() {
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
		String act = request.getParameter("doThisToCar");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
		} else if(act.equals("Delete Selected Car")) {
			Integer tempId = 0;
			//Accommodating for if nothing was selected and they pushed the button
			try { 
				tempId = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
			}
			
			dao.removeItem(tempId);
			
			getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
		} else if(act.equals("Edit Selected Car")) {
			Integer tempId = 0;
			//Accommodating for if nothing was selected and they pushed the button
			try { 
				tempId = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
			}
			Car carToEdit = dao.searchForCarById(tempId);
			request.setAttribute("carToEdit", carToEdit);
			getServletContext().getRequestDispatcher("/edit-car.jsp").forward(request, response);
		
		} else if(act.equals("Add New Car")) {
			getServletContext().getRequestDispatcher("/addCar.html").forward(request, response);
		}
	}

}
