package AgendaUserJDBC;

import AgendaUserDAO.GenericDAO;

/**
 * * Clase JDBCGenericDAO.
 * 
 * La clase abstracta JDBCGenericDAO implementa los métodos de la clase
 * GenericDAO. Teniendo de esta manera una clase generica abstracta que será
 * implementada por cada clase específica y permitirá persistir la información
 * en la base de datos.
 * 
 * Así como también, en esta clase abstracta se obtiene dos conexiones a la base
 * de datos para poder persistir la información.
 * @author jonnathan
 *
 */

public abstract class JDBCGenericDAO <T,ID> implements GenericDAO<T,ID>{
	protected ContextJDBC conexionUno = ContextJDBC.getJDBC1();
	protected ContextJDBC conexionDos = ContextJDBC.getJDBC2();
}
