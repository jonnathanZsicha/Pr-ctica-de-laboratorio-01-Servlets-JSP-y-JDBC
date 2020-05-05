package AgendaUserDAO;

/**
 * * Clase DAOFactory.
 * 
 * La clase abstracta DAOFcatory implementa el patrón de diseño Factory el cuál
 * busca tener una jerarquía de clases para su control e implementación de
 * manera organizada. En este ejemplo la clase DAOFactory declara los métodos
 * que serán implementados en la clase que podra gestionar el acceso y creación
 * de todos los DAOs específicos.
 * 
 * @author jonnathan
 *
 */
public abstract class DAOFactory {
	protected static DAOFactory factory = new JDBCDAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract void createTables();
	
	public abstract UsuarioDAO getUsuarioDao();
	
	public abstract TelefonoDAO getTelefonoDao();

}
