package clasesDAOimpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static final EntityManagerFactory em =
	Persistence.createEntityManagerFactory("persistence");
	
	public static EntityManagerFactory getEMF() {
		return em;
	}
	
}