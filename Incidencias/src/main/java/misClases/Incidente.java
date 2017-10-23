package misClases;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Incidente {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date fechaIncidente;
	private Date fechaExpediente;
	private String descripcion;
	private String resultado;
	@ManyToOne(optional = false)
	@JoinColumn(name="tipoIncidente_id")
	private TipoIncidente tipoIncidente;
	//estado?
	/*@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="incidente_id")
	private List<ObjetoInd> objetos;*/
	
	public Incidente() {
		
	}
	
	public Incidente(Date fechaIncidente, String descripcion) {
		this.setFechaExpediente(new Date());
		this.setResultado(null);
		this.setFechaIncidente(fechaIncidente);
		this.setDescripcion(descripcion);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaIncidente() {
		return fechaIncidente;
	}
	public void setFechaIncidente(Date fechaIncidente) {
		this.fechaIncidente = fechaIncidente;
	}
	public Date getFechaExpediente() {
		return fechaExpediente;
	}
	public void setFechaExpediente(Date fechaExpediente) {
		this.fechaExpediente = fechaExpediente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	/*public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<ObjetoInd> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<ObjetoInd> objetos) {
		this.objetos = objetos;
	}*/
	public TipoIncidente getTipoIncidente() {
		return tipoIncidente;
	}
	public void setTipoIncidente(TipoIncidente tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}
}
