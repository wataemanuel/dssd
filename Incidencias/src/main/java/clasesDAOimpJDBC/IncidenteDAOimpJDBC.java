package clasesDAOimpJDBC;

import org.springframework.stereotype.Repository;

import clasesDAO.IncidenteDAO;
import misClases.Incidente;

@Repository
public class IncidenteDAOimpJDBC extends GenericDAOimpJDBC<Incidente> implements IncidenteDAO {

	public IncidenteDAOimpJDBC() {
		super(Incidente.class);
	}
}
