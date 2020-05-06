package AgendaUserServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

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
@WebServlet("/elfServlet")
public class TelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TelefonoDAO telefonoDAO;
       private UsuarioDAO usuarioDAO;
       
       public void init() {
    	 usuarioDAO = DAOFactory.getFactory().getUsuarioDao();
		 telefonoDAO = DAOFactory.getFactory().getTelefonoDao();
       }
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
		    	
		    	String numero = request.getParameter("numero");
		    	String tipo = request.getParameter("tipo");
		    	String operadora = request.getParameter("operadora");
		    	System.out.println("ha llegado a crear un telefono");
				UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDao();
				TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDao();
				
				int id  = telefonoDAO.findultimoid();
				id = id+1;
				Telefono tel = new Telefono(id, numero, tipo , operadora );
				System.out.println(id);
				String correobusqueda = request.getParameter("correo");
				Usuario user = usuarioDAO.findByCorreo(correobusqueda);
				System.out.println("usuario"+user);
				tel.setUsuario(user);
				System.out.println("telefono ?"+tel);
				telefonoDAO.create(tel);
				System.out.print("\n---Creación de telefono\n");
				System.out.println(telefonoDAO.find());
		        showNewForm(request, response);
		        break;
		        
		    case "/delete":
				TelefonoDAO telefonoDAO2 = DAOFactory.getFactory().getTelefonoDao();
		    	System.out.println("ha llegado a eliminar un telefono");
		    	String ids = request.getParameter("id");
		    	int idi = Integer.parseInt(ids);
		    	Telefono te = telefonoDAO2.read(idi);
		    	telefonoDAO2.delete(te);
		    	System.out.print("\n---ElminaciÃ³n de telefono\n");
		        //deleteUser(request, response);
		        break;
		        
		    case "/edit":
		    	System.out.println("ha llegado a editar un telefono");
		        howEditForm(request, response);
		        break;
		    case "/update":
		    	System.out.println("ha llegado a modificar un telefono");
		        updateTelf(request, response);
		        break;
		    case "/buscarusuario":
		    	System.out.println("ha llegado a buscar un usuario");
		        //insertUser(request, response);
		        break;
		    case "/buscartelefono":
		    	System.out.println("ha llegado a buscar un telefono");
		        buscartelefono(request, response);
		        break;
		    default:
		        //listUser(request, response);
		        break;
		}
        
   
	}

	private void buscartelefono(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String numero = request.getParameter("numero");
		String correo = request.getParameter("correo");
		System.out.println(numero + correo);
		Telefono tel = telefonoDAO.findByNumero(numero);
		System.out.println("numero encontrado" + tel);
				
		
	}
		
		
	
	private void howEditForm(HttpServletRequest request, HttpServletResponse  response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
        Telefono existingUser = telefonoDAO.read(id);
        request.setAttribute("id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP+JSTL/TelefonoEdit.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void updateTelf(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        int id = Integer.parseInt( request.getParameter("id"));
        String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String operadora = request.getParameter("operadora");
        Telefono telf = new Telefono(id, numero, tipo, operadora);
        telefonoDAO.update(telf);
        System.out.println("se ha actualizado el telefono");
        response.sendRedirect("/JSP+JSTL/TelefonosList.jsp");
/**
        User book = new User(id, name, email, country);
        userDAO.updateUser(book);
        response.sendRedirect("list");
		sb4.setTelefonos(null);
		usuarioDAO.update(sb4);
		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP+JSTL/TelefonosList.jsp");
		dispatcher.forward(request, response);
		*/
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        

		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/SP+JSTL/TelefonosList.jsp").forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
