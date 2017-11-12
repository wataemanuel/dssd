package clasesDAOimpl;

import clasesDAO.IncidenteDAO;
import clasesDAO.TipoIncidenteDAO;
import clasesDAO.UsuarioDAO;

public class FactoryDAO {

	public FactoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOimpJPA();
	}
	
	public static IncidenteDAO getIncidenteDAO() {
		return new IncidenteDAOimpJPA();
	}
	
	public static TipoIncidenteDAO getTipoIncidenteDAO() {
		return new TipoIncidenteDAOimpJPA();
	}
	
	
}
