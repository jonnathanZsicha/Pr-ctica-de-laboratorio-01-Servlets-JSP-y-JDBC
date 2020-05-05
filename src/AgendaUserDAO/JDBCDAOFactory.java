package AgendaUserDAO;

import AgendaUserJDBC.JDBCTelefonoDAO;
import AgendaUserJDBC.JDBCUsuarioDAO;

/**
 * * Esta clase implementa los métodos abstractos de la clase DAOFatcory
 * gestionando de esta manera a través de esta clase el acceso a los DAOs que
 * persistiran la información en la base de datos.
 * 
 * @author jonnathan
 *
 */

public class JDBCDAOFactory extends DAOFactory{

	@Override
	public void createTables() {
		// TODO Auto-generated method stub
		this.getTelefonoDao().createTable();
		this.getUsuarioDao().createTable();
		
	}

	@Override
	public UsuarioDAO getUsuarioDao() {
		// TODO Auto-generated method stub
		return new JDBCUsuarioDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDao() {
		// TODO Auto-generated method stub
		return new JDBCTelefonoDAO();
	}
	

}
