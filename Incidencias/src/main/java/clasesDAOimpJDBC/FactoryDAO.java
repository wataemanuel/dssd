package clasesDAOimpJDBC;

import clasesDAO.IncidenteDAO;
import clasesDAO.TipoIncidenteDAO;
import clasesDAO.UsuarioDAO;

public class FactoryDAO {

	public FactoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOimpJDBC();
	}
	
	public static IncidenteDAO getIncidenteDAO() {
		return new IncidenteDAOimpJDBC();
	}
	
	public static TipoIncidenteDAO getTipoIncidenteDAO() {
		return new TipoIncidenteDAOimpJDBC();
	}
	
	
}
