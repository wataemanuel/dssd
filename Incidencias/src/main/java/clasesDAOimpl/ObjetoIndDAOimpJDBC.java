package clasesDAOimpl;

import org.springframework.stereotype.Repository;

import clasesDAO.ObjetoIndDAO;
import misClases.ObjetoInd;

@Repository
public class ObjetoIndDAOimpJDBC extends GenericDAOimpJDBC<ObjetoInd> implements ObjetoIndDAO {

	public ObjetoIndDAOimpJDBC() {
		super(ObjetoInd.class);
	}
}
