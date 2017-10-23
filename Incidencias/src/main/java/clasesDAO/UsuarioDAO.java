package clasesDAO;

import misClases.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{

	Boolean existeUsuario(String email, String pass);
	Usuario recuperarUsuario(String email, String pass);

}
