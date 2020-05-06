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
 * Servlet implementation class TelefonoServlet
 */
@WebServlet("/TelefonoServlet")
public class TelefonoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Object listUser = null;
	private TelefonoDAO telefonoDAO;
	private UsuarioDAO userDAO;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelefonoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
        String action = request.getServletPath();
       userDAO = DAOFactory.getFactory().getUsuarioDao();
       telefonoDAO = DAOFactory.getFactory().getTelefonoDao();
	}
/**
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listtelf(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listtelf(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	System.out.println(telefonoDAO.read(5));
    	
    	}
     
    

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("TelefonosList.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //User existingUser = userDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("TelefonosList.jsp");
        //request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
       // User newUser = new User(name, email, country);
       // userDAO.insertUser(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        //User book = new User(id, name, email, country);
       // userDAO.updateUser(book);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //userDAO.deleteUser(id);
        response.sendRedirect("list");

    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
