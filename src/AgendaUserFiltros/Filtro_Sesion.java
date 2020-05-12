package AgendaUserFiltros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filtro_Sesion
 */
@WebFilter({"/JSP/TelefonosList.jsp", "/JSP/TelefonoEdit.jsp"})
public class Filtro_Sesion implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro_Sesion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ha empezado el filtro");

		  HttpServletRequest req = (HttpServletRequest)request;
	      HttpServletResponse res = (HttpServletResponse)response;
	      HttpSession session =((HttpServletRequest) request).getSession();
	

	      String correo =  (String) session.getAttribute("correo");
	      System.out.println("este es el correo"+ correo);
	      
	      if (correo != null) {
	    	  
		      System.out.println("hay una sesion iniciada :" + correo);
	    	  request.getRequestDispatcher( "/JSP/TelefonosList.jsp" ).forward( request, response );
		} else {
			System.out.println("obligatorio inicio de sesion :" );
	    	request.getRequestDispatcher( "/Html/login.html" ).forward( request, response );
		}
	      chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
