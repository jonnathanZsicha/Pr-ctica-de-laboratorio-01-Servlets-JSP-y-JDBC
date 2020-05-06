package AgendaUserJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import AgendaUserDAO.DAOFactory;

import AgendaUserDAO.TelefonoDAO;
import AgendaUserDAO.UsuarioDAO;
import AgendaUserModel.Telefono;
import AgendaUserModel.Usuario;

/**
 * Clase JDBCShoppingBasketDAO.
 * 
 * La clase JDBCShoppingBasketDAO hereda los métodos y atributos de la clase abstracta
 * padre JDBCGenericDAO, así como también, implementa los métodos de la
 * interface ShoppingBasketDAO.
 * 
 * Teniendo de esta manera una clase específica que gestionara la persistencia a
 * la base de datos del modelo ShoppingBasket
 * 
 * @author jonnathan
 *
 */

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario , String> implements UsuarioDAO{

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		conexionUno.update("DROP TABLE IF EXISTS Telefono");
		conexionUno.update("DROP TABLE IF EXISTS Usuario");
		conexionUno.update("CREATE TABLE Usuario ( USU_CEDULA varchar(10) NOT NULL,USU_NOMBRE varchar(255),USU_APELLIDO varchar(255),USU_CORREO varchar(255),USU_PASSWORD varchar(255),PRIMARY KEY (USU_CEDULA))");
		DAOFactory.getFactory().getTelefonoDao().createTable();
		
	}

	@Override
	public void create(Usuario usuario) {
		// TODO Auto-generated method stub
		
	System.out.println("INSERT Usuario VALUES ('" + usuario.getCedula() + "','" + usuario.getNombre() 
						+ "','" + usuario.getApellido() + "','" + usuario.getCorreo() + "','" 
						+ usuario.getPassword() + "')" );
	
	conexionUno.update("INSERT Usuario VALUES ('" + usuario.getCedula() + "','" + usuario.getNombre() 
						+ "','" + usuario.getApellido() + "','" + usuario.getCorreo() + "','" 
						+ usuario.getPassword() + "')");
	
	Set <Telefono> telefonos = usuario.getTelefonos();
	if (telefonos != null) {
		for (Telefono telefono : telefonos) {
			DAOFactory.getFactory().getTelefonoDao().create(telefono);
		}
	}
	}
	
	@Override
	public Usuario read(String id) {
		// TODO Auto-generated method stub
		Usuario usuario = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Usuario WHERE usu_cedula='" + id + "'");
		try {
			if (rs != null && rs.next()) {
				
				usuario = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),
										rs.getString("usu_correo"), rs.getString("usu_password"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
		}
		if (usuario == null) {
			return null;
		}
		Set<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDao().findByUsuarioId(usuario.getCedula());
		if (telefonos != null) {
			Set<Telefono> telefonosFinal = new HashSet<Telefono>();
			for (Telefono telefono : telefonos) {
				telefono.setUsuario(usuario);
				telefonosFinal.add(telefono);
			}
			usuario.setTelefonos(telefonosFinal);
		}

		return usuario;
	}


	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDao();
		Set<Telefono> telefonos = telefonoDAO.findByUsuarioId(usuario.getCedula());
		conexionUno.update("UPDATE Usuario   SET usu_nombre = '" + usuario.getNombre() + "' WHERE usu_cedula = '"
				+ usuario.getCedula()+"'");

		if (usuario.getTelefonos() == null && telefonos != null) {
			for (Telefono telefono : telefonos) {
				telefonoDAO.delete(telefono);
			}
		} else if (usuario.getTelefonos() != null && telefonos == null) {
			for (Telefono telefono : usuario.getTelefonos()) {
				telefonoDAO.create(telefono);
			}
		} else if (usuario.getTelefonos() != null && telefonos != null) {
			for (Telefono telefono : usuario.getTelefonos()) {
				telefonoDAO.update(telefono);
			}
		}

	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		if (usuario.getTelefonos() != null) {
			for (Telefono telefonos: usuario.getTelefonos()) {
				DAOFactory.getFactory().getTelefonoDao().delete(telefonos);
			}
		}
		conexionUno.update("DELETE FROM Usuario WHERE usu_cedula = '" + usuario.getCedula()+"'");

		
	}

	@Override
	public List<Usuario> find() {
		// TODO Auto-generated method stub
		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rs = conexionUno.query("SELECT * FROM Usuario");
		try {
			while (rs.next()) {
				
				Usuario usuario = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),
						rs.getString("usu_correo"), rs.getString("usu_password"));
				Set<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDao()
						.findByUsuarioId(usuario.getCedula());				

				if (telefonos != null) {

					Set<Telefono> telefonosFinal = new HashSet<Telefono>();
					for (Telefono telefono : telefonos) {
						telefono.setUsuario(usuario);
						telefonosFinal.add(telefono);
					}
					usuario.setTelefonos(telefonosFinal);

				}

				list.add(usuario);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:find): " + e.getMessage());
		}
		return list;
	}

	@Override
	public Usuario findByCorreo(String correobusqueda) {
		// TODO Auto-generated method stub
		Usuario usuario = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Usuario WHERE usu_correo='" + correobusqueda + "'");
		try {
			if (rs != null && rs.next()) {
				
				usuario = new Usuario(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),
										rs.getString("usu_correo"), rs.getString("usu_password"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
		}
		if (usuario == null) {
			return null;
		}
		Set<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDao().findByUsuarioId(usuario.getCedula());
		if (telefonos != null) {
			Set<Telefono> telefonosFinal = new HashSet<Telefono>();
			for (Telefono telefono : telefonos) {
				telefono.setUsuario(usuario);
				telefonosFinal.add(telefono);
			}
			usuario.setTelefonos(telefonosFinal);
		}

		return usuario;
	

	}






}
