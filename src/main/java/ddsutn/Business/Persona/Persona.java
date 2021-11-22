package ddsutn.Business.Persona;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ddsutn.Business.Notificacion.Notificar;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rol", discriminatorType = DiscriminatorType.STRING)

public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	protected TipoDcto tipoDocumento;

	protected String nroDocumento;
	protected Date fechaDeNacimiento;

	@OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
	@JsonManagedReference
	protected List<Contacto> otrosContactos;

	protected String domicilio;
	protected String nombre;
	protected String apellido;
	protected String telefono;
	protected String email;

	@Transient
	private List<Notificar> formasDeNotificacion;

	private String formasNotificacion;

	public Persona(TipoDcto tipoDocumento, String nroDocumento, Date fechaDeNacimiento, List<Contacto> otrosContactos, String domicilio, String nombre, String apellido, String telefono, String email, List<Notificar> formasDeNotificacion) {
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.otrosContactos = otrosContactos;
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.formasDeNotificacion = formasDeNotificacion;
	}

	public void notificarAMisContactos(String mensaje) {
		// this.contacto.recibirNotificacion(mensaje);
		this.otrosContactos.forEach(unContacto -> unContacto.recibirNotificacion(mensaje));
	}

}
