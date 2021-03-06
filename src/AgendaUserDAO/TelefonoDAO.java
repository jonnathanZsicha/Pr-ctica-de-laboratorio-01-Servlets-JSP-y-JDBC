package AgendaUserDAO;

import java.util.Set;

import AgendaUserModel.Telefono;
import AgendaUserModel.Usuario;



public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
	
	public abstract Set<Telefono> findByUsuarioId(String usuariocedula);
	 public abstract int findultimoid();
	 public abstract Set<Telefono> findByNumero(String numero);

}
