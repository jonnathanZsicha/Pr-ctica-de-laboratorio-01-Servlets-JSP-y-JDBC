package AgendaUserDAO;

import java.util.Set;

import AgendaUserModel.Telefono;



public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
	
	public abstract Set<Telefono> findByUsuarioId(String usuariocedula);
	 public abstract int findultimoid();

}
