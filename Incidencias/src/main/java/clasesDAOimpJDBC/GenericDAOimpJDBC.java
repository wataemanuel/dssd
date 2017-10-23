package clasesDAOimpJDBC;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import clasesDAO.GenericDAO;

@Transactional
public abstract class GenericDAOimpJDBC<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
	this.entityManager = em;
	}
	public EntityManager getEntityManager() {
	return entityManager;
	}
	
	public GenericDAOimpJDBC(Class<T> persist){
		this.persistentClass = persist;
	}

	@Override
	public T persistir(T entidad) {
		this.getEntityManager().persist(entidad);
		return entidad;
	}
	
	@Override
	public T borrar(Serializable id) {
		T entity = null;
		entity = this.getEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
			this.getEntityManager().remove(entity);
		}
		return entity;
	}
	
	@Override
	public void borrar(T entidad) {
		this.getEntityManager().remove(this.getEntityManager().merge(entidad));
	
	}

	@Override
	public T actualizar(T entidad) {
		entidad = this.getEntityManager().merge(entidad);
		return entidad;
	}

	@Override
	public T recuperar(Serializable id) {
		T entidad = null;
		entidad =  this.getEntityManager().find(this.getPersistentClass(), id);
		return entidad;
	}

	@Override
	public List<T> recuperarTodos() {
		List<T> resultado = null;
		Query consulta = this.getEntityManager().createQuery("SELECT e FROM " + this.getPersistentClass().getSimpleName() + " e");
		resultado = consulta.getResultList();
		return resultado;
	}

	@Override
	public Boolean existe(Serializable id) {
		Boolean existe = false;
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
			existe = true;
		}
		return existe;
	}

}
