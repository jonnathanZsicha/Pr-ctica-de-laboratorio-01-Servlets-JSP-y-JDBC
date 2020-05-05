package AgendaUserServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AgendaUserDAO.DAOFactory;
import AgendaUserDAO.UsuarioDAO;

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
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDao();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		
		String correobusqueda = request.getParameter("correo");
		Usuario user = usuarioDAO.findByCorreo(correobusqueda);
		
		if (user != null) {
			System.out.println(user);
			String correo = user.getCorreo();
			String password= user.getPassword();
			
			if (session.isNew()) {
				session.setAttribute("acceso", true);
				session.setAttribute("correo",correo );
				if ((correo.equals(request.getParameter("correo"))) && (password.equals(request.getParameter("password")))  ) {
					boolean bool =  (boolean) session.getAttribute("acceso");
					System.out.println("creacion 1ra sesion acceso :"+ bool);
					request.getRequestDispatcher( "/Formulario.html" ).forward( request, response );
				}	
			}else {
				if ((correo.equals(request.getParameter("correo"))) && (password.equals(request.getParameter("password")))  ) {
					session.setAttribute("correo",correo );
					request.getRequestDispatcher( "/Formulario.html" ).forward( request, response );
				}
				
			}
			
		}else {
			
			request.getRequestDispatcher( "/login.html" ).forward( request, response );
		}
						
		response.setContentType("text/html");
		out.println("<html><head><title><Cookies></title></head><body>");
		out.println("<p> caracteres incorrectos....</p></body></html>");
		
		
	
	
	}
}
