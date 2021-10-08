package ddsutn.Business.Persona;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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

	protected int nroDocumento;
	protected Date fechaDeNacimiento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_contacto_propio")
	protected Contacto contacto;

	@OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
	protected List<Contacto> otrosContactos;

	protected String domicilio;


	// Pongo el constructor normal porque sino cuando Duenio hereda de Persona lombok me tiraba error
	public Persona(TipoDcto tipoDocumento, int nroDocumento, Date fechaDeNacimiento, Contacto contacto, List<Contacto> otrosContactos, String domicilio) {
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.contacto = contacto;
		this.otrosContactos = otrosContactos;
		this.domicilio = domicilio;
	}

    public void notificarAMisContactos(String mensaje) {
        this.contacto.recibirNotificacion(mensaje);
        this.otrosContactos.forEach(unContacto -> unContacto.recibirNotificacion(mensaje));
    }

}
