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
 * Servlet implementation class ActualizarTelefonoControler
 */
@WebServlet("/ActualizarTelefonoController")
public class ActualizarTelefonoControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String url = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarTelefonoControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDao();
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDao();
		 int id = Integer.parseInt( request.getParameter("id"));
	        String numero = request.getParameter("numero");
	        String tipo = request.getParameter("tipo");
	        String operadora = request.getParameter("operadora");
	        System.out.println("esperando para actualizar"+ numero + tipo + operadora);
	        Telefono telf = new Telefono(id, numero, tipo, operadora);
	        telefonoDAO.update(telf);
	        System.out.println("se ha actualizado el telefono");
	        String correo = request.getParameter("correo");
	    	Usuario user = usuarioDAO.findByCorreo(correo);
	    	Set<Telefono> telefonos=telefonoDAO.findByUsuarioId(user.getCedula());
	    	request.setAttribute("telefonos", telefonos);
	        url = "/JSP/TelefonosList.jsp";
	        request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
