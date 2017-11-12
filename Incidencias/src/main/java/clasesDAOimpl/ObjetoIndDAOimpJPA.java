package clasesDAOimpl;

import org.springframework.stereotype.Repository;

import clasesDAO.ObjetoIndDAO;
import misClases.ObjetoInd;

@Repository
public class ObjetoIndDAOimpJPA extends GenericDAOimpJPA<ObjetoInd> implements ObjetoIndDAO {

	public ObjetoIndDAOimpJPA() {
		super(ObjetoInd.class);
	}
}
