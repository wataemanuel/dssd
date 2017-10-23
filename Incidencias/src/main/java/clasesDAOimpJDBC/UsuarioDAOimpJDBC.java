package clasesDAOimpJDBC;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import misClases.Usuario;
import clasesDAO.UsuarioDAO;

@Repository
public class UsuarioDAOimpJDBC extends GenericDAOimpJDBC<Usuario> implements UsuarioDAO {

	public UsuarioDAOimpJDBC(){
		super(Usuario.class);
	}
	
	@Override
	public Boolean existeUsuario(String email, String pass) {
		Boolean existe = false;
		Query consulta = this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.email = :usuario AND u.password = :clave");
		consulta.setParameter("usuario", email);
		consulta.setParameter("clave", pass);
		int resultado = consulta.getResultList().size();
		if (resultado == 1) {
			existe = true;
		}
		return existe;
	}
	
	@Override
	public Usuario recuperarUsuario(String email, String pass) {
		Query consulta = this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.email = :usuario AND u.password = :clave");
		consulta.setParameter("usuario", email);
		consulta.setParameter("clave", pass);
		Usuario resultado = (Usuario) consulta.getSingleResult();
		return resultado;
	}

}