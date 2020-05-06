package AgendaUserServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class TelfServlet
 */
@WebServlet("/")
public class TelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TelefonoDAO telefonoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

        switch (action) {
		    case "/new":
		    	System.out.println("ha llegado a crear un telefono");
		        showNewForm(request, response);
		        break;
		    case "/delete":
		    	System.out.println("ha llegado a eliminar un telefono");
		        //deleteUser(request, response);
		        break;
		    case "/insert":
		    	System.out.println("ha llegado a insertar un telefono");
		        insert(request, response);
		        break;
		    case "/edit":
		    	System.out.println("ha llegado a editar un telefono");
		        //showEditForm(request, response);
		        break;
		    case "/update":
		    	System.out.println("ha llegado a modificar un telefono");
		        //updateUser(request, response);
		        break;
		    case "/buscarusuario":
		    	System.out.println("ha llegado a buscar un usuario");
		        //insertUser(request, response);
		        break;
		    case "/buscartelefono":
		    	System.out.println("ha llegado a buscar un telefono");
		        //insertUser(request, response);
		        break;
		    default:
		        //listUser(request, response);
		        break;
		}
        
   
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("numero");
		String email = request.getParameter("tipo");
		String country = request.getParameter("operadora");
		
		Telefono p7 = new Telefono(8, "0981951047", "Celu8" , "Movistar8"  );
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDao();
		String correobusqueda = request.getParameter("correo");
		Usuario user = usuarioDAO.findByCorreo(correobusqueda);
		System.out.println("usuario"+user);

		
		p7.setUsuario(user);
		telefonoDAO.create(p7);
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP+JSTL/TelefonoNew.jsp");
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
