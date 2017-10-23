package misClases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ObjetoInd {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int cantidad;
	private String desripcion;
	
	public ObjetoInd() {
		
	}
	
	public ObjetoInd(String nombre, int cantidad, String descripcion) {
		this.setNombre(nombre);
		this.setCantidad(cantidad);
		this.setDesripcion(descripcion);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDesripcion() {
		return desripcion;
	}
	public void setDesripcion(String desripcion) {
		this.desripcion = desripcion;
	}
}
