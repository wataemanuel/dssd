package clasesDAOimpl;

import org.springframework.stereotype.Repository;

import clasesDAO.EstadoDAO;
import misClases.Estado;

@Repository
public class EstadoDAOimpJPA extends GenericDAOimpJPA<Estado> implements EstadoDAO {

	public EstadoDAOimpJPA() {
		super(Estado.class);
	}
}
