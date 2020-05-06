package AgendaUserDAO;



import AgendaUserModel.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario , String>{
	
	public abstract Usuario findByCorreo(String correobusqueda);

}
