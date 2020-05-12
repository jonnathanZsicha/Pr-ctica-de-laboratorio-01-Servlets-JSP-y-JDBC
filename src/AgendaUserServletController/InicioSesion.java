package AgendaUserServletController;


import java.io.IOException;

import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import AgendaUserDAO.DAOFactory;
import AgendaUserDAO.TelefonoDAO;
import AgendaUserDAO.UsuarioDAO;
import AgendaUserModel.Telefono;
import AgendaUserModel.Usuario;

/**
 * Servlet implementation class InicioSesion
 */
@WebServlet("/InicioSesion")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDao();
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDao();

		HttpSession session = request.getSession(true);
		String correobusqueda = request.getParameter("correo");
		Usuario user = usuarioDAO.findByCorreo(correobusqueda);
		String url = null;
		try {
			if (user != null) {
				System.out.println(user);
				String correo = user.getCorreo();
				String password= user.getPassword();
				String cedula=user.getCedula();
				if (session.isNew()) {
					session.setAttribute("acceso", true);
					session.setAttribute("correo",correo );
					session.setAttribute("cedula",cedula );
					if ((correo.equals(request.getParameter("correo"))) && (password.equals(request.getParameter("password")))  ) {
						boolean bool =  (boolean) session.getAttribute("acceso");
						System.out.println("creacion 1ra sesion acceso :"+ bool);
				       Set<Telefono> telefonos=telefonoDAO.findByUsuarioId(user.getCedula());
				       System.out.println("estos son todos los telefonos" + telefonos);
				        request.setAttribute("telefonos", telefonos);
				        /*
						for (Telefono telefonos : telefonoDAO.findByUsuarioId(user.getCedula())) {
							System.out.println(telefonos);
						}*/
						url = "/JSP/TelefonosList.jsp";
					}	
				}else {
					if ((correo.equals(request.getParameter("correo"))) && (password.equals(request.getParameter("password")))  ) {
						session.setAttribute("correo",correo );
						session.setAttribute("cedula",cedula );
						Set<Telefono> telefonos=telefonoDAO.findByUsuarioId(user.getCedula());
						System.out.println(telefonos);
						request.setAttribute("telefonos", telefonos);
						url = "/JSP/TelefonosList.jsp";
					}
					
				}
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(url);
		request.getRequestDispatcher(url).forward(request, response);
	
	}
}
