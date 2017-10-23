package clasesDAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {

	public abstract T persistir(T entidad);
	public abstract T borrar (Serializable id);
	public abstract void borrar(T entidad);
	public abstract T actualizar(T entidad);
	public abstract T recuperar(Serializable id);
	public abstract List<T> recuperarTodos();
	public abstract Boolean existe(Serializable id);
	
}