package clasesDAOimpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import misClases.Incidente;
import misClases.Usuario;
import clasesDAO.UsuarioDAO;

@Repository
public class UsuarioDAOimpJPA extends GenericDAOimpJPA<Usuario> implements UsuarioDAO {

	public UsuarioDAOimpJPA(){
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
	
	@Override
	public List<Incidente> recuperarIncidentes(Serializable id) {
		List<Incidente> resultado = null;
		Query consulta = this.getEntityManager().createQuery("SELECT elu FROM " + this.getPersistentClass().getSimpleName() + " e JOIN e.incidentes elu WHERE e.id = " + id + "");
		resultado = consulta.getResultList();
		return resultado;
	}

}