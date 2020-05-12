package AgendaUserServletController;

import java.awt.List;
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
 * Servlet implementation class BuscarUsuarioController
 */
@WebServlet("/BuscarUsuarioController")
public class BuscarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private TelefonoDAO telefonoDAO;
	private Usuario usuario;
	private String url = null;
	private String busqueda = null;
	 
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUsuarioController() {
        super();
        usuarioDAO = DAOFactory.getFactory().getUsuarioDao();
        telefonoDAO = DAOFactory.getFactory().getTelefonoDao();
        usuario = new Usuario();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		try {
			if (request.getParameter("correo") != null) {
				String busqueda = request.getParameter("busqueda");
				usuario = usuarioDAO.findByCorreo(busqueda);
				request.setAttribute("usuario", usuario);
				System.out.println("ha buscado este usuario"+usuario);
				
				Set<Telefono> telefonos = telefonoDAO.findByUsuarioId(usuario.getCedula());
				request.setAttribute("telefonos", telefonos);
				System.out.println("ha ontenido las siguentes telefonos"+telefonos);
				url = "/JSP/UsuarioBuscar.jsp";
				
			} else {
				if (request.getParameter("cedula") !=null) {
					String busqueda = request.getParameter("busqueda");
					usuario = usuarioDAO.read(busqueda);
					request.setAttribute("usuario", usuario);
					System.out.println("ha buscado este usuario"+usuario);
					
					Set<Telefono> telefonos = telefonoDAO.findByUsuarioId(usuario.getCedula());
					request.setAttribute("telefonos", telefonos);
					System.out.println("ha ontenido las siguentes telefonos"+telefonos);
					url = "/JSP/UsuarioBuscar.jsp";	
					
				} else {
					if (request.getParameter("nombre") !=null) {
						
					}

				}

			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
