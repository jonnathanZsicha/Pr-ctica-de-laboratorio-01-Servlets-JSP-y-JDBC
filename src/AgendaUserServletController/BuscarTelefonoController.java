package AgendaUserServletController;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AgendaUserDAO.DAOFactory;
import AgendaUserDAO.TelefonoDAO;
import AgendaUserDAO.UsuarioDAO;
import AgendaUserModel.Telefono;
import AgendaUserModel.Usuario;

/**
 * Servlet implementation class BuscarTelefonoController
 */
@WebServlet("/BuscarTelefonoController")
public class BuscarTelefonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = null;
	private UsuarioDAO usuarioDAO;
	private TelefonoDAO telefonoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarTelefonoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		usuarioDAO=DAOFactory.getFactory().getUsuarioDao();
		telefonoDAO= DAOFactory.getFactory().getTelefonoDao();
		
    	System.out.println("ha llegado a buscar un telefono");
    	String numero = request.getParameter("numero");
		Set<Telefono> telefonos =telefonoDAO.findByNumero(numero);
    	request.setAttribute("telefonos", telefonos);
		System.out.print("telefono econtrado");
        url = "/JSP/TelefonosList.jsp";
        request.getRequestDispatcher(url).forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
