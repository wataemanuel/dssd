package test;

import clasesDAOimpl.UsuarioDAOimpJPA;
import misClases.Usuario;

public class Test {

	public static Usuario crearUsuario() {
		Usuario user = new Usuario();
		user.setApellido("Delcuadri");
		user.setNombre("Ivan");
		user.setEmail("eltraidor@yahoo.com.ar");
		user.setPassword("123456");
		return user;
	}
	
	public static void main(String[] args) {
		
		Usuario u1 = crearUsuario();
		UsuarioDAOimpJPA uu1 = new UsuarioDAOimpJPA();
		uu1.persistir(u1);
		
	}

}
