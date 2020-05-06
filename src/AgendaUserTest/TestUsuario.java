package AgendaUserTest;


import java.util.HashSet;
import java.util.Set;


import AgendaUserDAO.DAOFactory;
import AgendaUserDAO.TelefonoDAO;
import AgendaUserDAO.UsuarioDAO;
import AgendaUserModel.Telefono;
import AgendaUserModel.Usuario;


public class TestUsuario {
	public static void main(String[] args) {
	UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDao();
	TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDao();

	usuarioDAO.createTable();

	Usuario sb1, sb2, sb3;

	sb1 = new Usuario("0106232811","Jonnthan1","Sicha1","rsicha50gmail.com","hola1");
	sb2 = new Usuario("0106232812","Jonnthan2","Sicha2","rsicha51gmail.com","hola2");
	sb3 = new Usuario("0106232813","Jonnthan3","Sicha3","rsicha52gmail.com","hola3");

	Telefono p1 = new Telefono(1, "0981951041", "Celu" , "Movistar"  );
	Telefono p2 = new Telefono(2, "0981951042", "Celular" , "claro"  );
	Telefono p3 = new Telefono(3, "0981951043", "convencional" , "Movistar"  );
	Telefono p4 = new Telefono(4, "0981951044", "Celu" , "claro"  );
	Telefono p5 = new Telefono(5, "0981951045", "Covencional" , "Movistar"  );
	Telefono p6 = new Telefono(6, "0981951046", "Comvencio" , "claro"  );
	


	p1.setUsuario(sb1);
	p2.setUsuario(sb1);
	p3.setUsuario(sb2);
	p4.setUsuario(sb2);
	p5.setUsuario(sb3);
	p6.setUsuario(sb3);
	
	

	Set<Telefono> telefonos1 = new HashSet<Telefono>();
	Set<Telefono> telefonos2 = new HashSet<Telefono>();
	Set<Telefono> telefonos3 = new HashSet<Telefono>();

	telefonos1.add(p1);
	telefonos1.add(p2);

	telefonos2.add(p3);
	telefonos2.add(p4);

	telefonos3.add(p5);
	telefonos3.add(p6);

	sb1.setTelefonos(telefonos1);
	sb2.setTelefonos(telefonos2);
	sb3.setTelefonos(telefonos3);

	usuarioDAO.create(sb1);
	usuarioDAO.create(sb2);
	usuarioDAO.create(sb3);

	System.out.print("---Creacion de usuario\n");
	for (Usuario usuario : usuarioDAO.find()) {
		System.out.println(usuario);
		for (Telefono telefono : usuario.getTelefonos()) {
			System.out.println(telefono);
		}
	}

	Telefono p7 = new Telefono(7, "0981951047", "Celu7" , "Movistar7"  );
	
	p7.setUsuario(sb1);
	telefonoDAO.create(p7);
	System.out.print("\n---Creación de telefono\n");
	System.out.println(telefonoDAO.find());

	
	System.out.print("\nBuscar usuario 2\n");
	Usuario sb4 = usuarioDAO.read("0106232812");
	System.out.println(sb4);
	for (Telefono telefono : sb4.getTelefonos()) {
		System.out.println(telefono);
	}

	System.out.print("\nBuscar telefonos 5\n");
	System.out.println(telefonoDAO.read(5));

	sb4.setTelefonos(null);
	usuarioDAO.update(sb4);

	System.out.print("\n---Actualización de usuario\n");
	for (Usuario usuario : usuarioDAO.find()) {
		System.out.println(usuario);
		for (Telefono telefono : usuario.getTelefonos()) {
			System.out.println(telefono);
		}
	}
	
	telefonoDAO.delete(p7);
	System.out.print("\n---Elminación de telefono\n");
	for (Telefono telefono : telefonoDAO.findByUsuarioId(sb1.getCedula())) {
		System.out.println(telefono);
	}


	usuarioDAO.delete(sb3);
	System.out.print("\n---Eliminación de carrito de compras\n");
	for (Usuario usuario : usuarioDAO.find()) {
		System.out.println(usuario);
		for (Telefono telefono : usuario.getTelefonos()) {
			System.out.println(telefono);
		}
	}
	
	Telefono p8 = new Telefono(8, "0981951047", "Celu8" , "Movistar8"  );
	p8.setUsuario(sb3);
	telefonoDAO.create(p8);
	System.out.print("\n---Creación de telefono\n");
	System.out.println(telefonoDAO.find());
	
	
	
}

}
