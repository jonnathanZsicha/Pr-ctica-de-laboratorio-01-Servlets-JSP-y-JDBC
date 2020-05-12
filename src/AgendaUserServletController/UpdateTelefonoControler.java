package AgendaUserServletController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AgendaUserDAO.DAOFactory;
import AgendaUserDAO.TelefonoDAO;
import AgendaUserModel.Telefono;

/**
 * Servlet implementation class UpdateTelefonoControler
 */
@WebServlet("/UpdateTelefonoController")
public class UpdateTelefonoControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTelefonoControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDao();
        Telefono existingUser = telefonoDAO.read(id);
        request.setAttribute("id", id);
        request.setAttribute("numero", request.getParameter("numero"));
        request.setAttribute("tipo",request.getParameter("tipo"));
        request.setAttribute("operadora", request.getParameter("operadora"));
 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/TelefonoEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
