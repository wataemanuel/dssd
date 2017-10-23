package misClases;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Usuario {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String apellido;
	private String nombre;
	@NotNull
	@Size(min = 6, max = 20)
	private String password;
	@NotNull
	private String email;
	private String dni;
	
	public Usuario() {
		
	}
	
	public Usuario(String apellido, String nombre, String password, String email) {
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setPassword(password);
		this.setEmail(email);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
}
