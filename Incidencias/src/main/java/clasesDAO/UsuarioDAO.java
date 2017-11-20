package clasesDAO;

import java.io.Serializable;
import java.util.List;

import misClases.Incidente;
import misClases.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{

	Boolean existeUsuario(String email, String pass);
	Usuario recuperarUsuario(String email, String pass);
	List<Incidente> recuperarIncidentes(Serializable id);

}
