package clasesDAOimpl;

import org.springframework.stereotype.Repository;

import clasesDAO.TipoIncidenteDAO;
import misClases.TipoIncidente;

@Repository
public class TipoIncidenteDAOimpJPA extends GenericDAOimpJPA<TipoIncidente> implements TipoIncidenteDAO {

	public TipoIncidenteDAOimpJPA() {
		super(TipoIncidente.class);
	}
}
