package misClases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoIncidente {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	
	public TipoIncidente() {

	}

	public TipoIncidente(String descripcion) {
		this.setDescripcion(descripcion);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
