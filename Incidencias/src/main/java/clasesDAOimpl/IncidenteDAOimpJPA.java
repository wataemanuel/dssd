package clasesDAOimpl;

import org.springframework.stereotype.Repository;

import clasesDAO.IncidenteDAO;
import misClases.Incidente;

@Repository
public class IncidenteDAOimpJPA extends GenericDAOimpJPA<Incidente> implements IncidenteDAO {

	public IncidenteDAOimpJPA() {
		super(Incidente.class);
	}

}
