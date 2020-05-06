package AgendaUserJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import AgendaUserDAO.TelefonoDAO;
import AgendaUserModel.Telefono;
import AgendaUserModel.Usuario;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO{

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		conexionDos.update("DROP TABLE IF EXISTS Telefono");
		conexionDos.update("CREATE TABLE Telefono ( TEL_CODIGO INT NOT NULL, "
				+ "TEL_NUMERO VARCHAR(255),TEL_TIPO VARCHAR(255),TEL_OPERADORA VARCHAR(255), USU_CEDULA_ID VARCHAR(255), PRIMARY KEY (TEL_CODIGO),"
				+ "FOREIGN KEY(USU_CEDULA_ID) REFERENCES Usuario(USU_CEDULA))");
	}
		

	@Override
	public void create(Telefono telefono) {
		// TODO Auto-generated method stub
		conexionDos.update("INSERT Telefono VALUES (" + telefono.getId() + ",'" + telefono.getNumero() + "','" 
							+ telefono.getTipo() + "','" + telefono.getOperadora() + "','"
							+ telefono.getUsuario().getCedula() + "')");
	}

	@Override
	public Telefono read(Integer id) {
		// TODO Auto-generated method stub
		Telefono telefono = null;
		ResultSet rsTelefono = conexionUno.query("SELECT * FROM Telefono WHERE tel_codigo=" + id);
		try {
			if (rsTelefono != null && rsTelefono.next()) {
				telefono = new Telefono(rsTelefono.getInt("tel_codigo"), rsTelefono.getString("tel_numero"),
										rsTelefono.getString("tel_tipo"),rsTelefono.getString("tel_operadora"));
				ResultSet rsUsuario = conexionDos
						.query("SELECT * FROM Usuario WHERE usu_cedula= '" + rsTelefono.getString("USU_CEDULA_ID")+"'");

				if (rsUsuario != null && rsUsuario.next()) {
					
					Usuario usuario = new Usuario(rsUsuario.getString("usu_cedula"), rsUsuario.getString("usu_nombre"),
							rsUsuario.getString("usu_apellido"),rsUsuario.getString("usu_correo"), rsUsuario.getString("usu_password"));
					telefono.setUsuario(usuario);
				}

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:read): " + e.getMessage());
		}
		if (telefono == null) {
			return null;
		}
		return telefono;
	}

	@Override
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		
		conexionUno.update("UPDATE Telefono SET tel_tipo = '" + telefono.getTipo() + "',tel_numero = '"
				+ telefono.getNumero() + "' WHERE tel_codigo = " + telefono.getId());
		
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		
		conexionUno.update("DELETE FROM Telefono WHERE tel_codigo = " + telefono.getId());
		
	}

	@Override
	public List<Telefono> find() {
		
		// TODO Auto-generated method stub
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rsTelefono = conexionUno.query("SELECT * FROM Telefono");
		try {
			while (rsTelefono.next()) {
				Telefono telefono = new Telefono(rsTelefono.getInt("tel_codigo"), rsTelefono.getString("tel_numero"),
						rsTelefono.getString("tel_tipo"),rsTelefono.getString("tel_operadora"));
				ResultSet rsUsuario = conexionDos
						.query("SELECT * FROM Usuario WHERE usu_cedula ='" + rsTelefono.getString("usu_cedula_id")+"'");

				if (rsUsuario != null && rsUsuario.next()) {
				
					Usuario usuario = new Usuario(rsUsuario.getString("usu_cedula"), rsUsuario.getString("usu_nombre"),
							rsUsuario.getString("usu_apellido"),rsUsuario.getString("usu_correo"), rsUsuario.getString("usu_password"));
					telefono.setUsuario(usuario);
				}
				list.add(telefono);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());
		}

		return list;
	}

	@Override
	public Set<Telefono> findByUsuarioId(String usuariocedula) {
		// TODO Auto-generated method stub
		Set<Telefono> list = new HashSet<Telefono>();
		
		ResultSet rsTelefono = conexionDos.query("SELECT * FROM Telefono WHERE usu_cedula_id='" + usuariocedula + "'");
		try {
			while (rsTelefono.next()) {
				Telefono telefono = new Telefono(rsTelefono.getInt("tel_codigo"), rsTelefono.getString("tel_numero"),
						rsTelefono.getString("tel_tipo"),rsTelefono.getString("tel_operadora"));
				list.add(telefono);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:findUsuarioId): " + e.getMessage());
		}

		return list;
	}


	@Override
	public int findultimoid() {
		// TODO Auto-generated method stub
		ResultSet rsTelefono = conexionUno.query("SELECT MAX(tel_codigo) AS id FROM telefono");
		int id = 0;
		
		try {
			while (rsTelefono.next()) {
				 id = rsTelefono.getInt("id");
			}
			
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:finultimoId): " + e.getMessage());
	}
		return id;
}
}
