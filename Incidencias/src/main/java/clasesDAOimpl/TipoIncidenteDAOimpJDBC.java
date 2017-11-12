package clasesDAOimpl;

import org.springframework.stereotype.Repository;

import clasesDAO.TipoIncidenteDAO;
import misClases.TipoIncidente;

@Repository
public class TipoIncidenteDAOimpJDBC extends GenericDAOimpJDBC<TipoIncidente> implements TipoIncidenteDAO {

	public TipoIncidenteDAOimpJDBC() {
		super(TipoIncidente.class);
	}
}
