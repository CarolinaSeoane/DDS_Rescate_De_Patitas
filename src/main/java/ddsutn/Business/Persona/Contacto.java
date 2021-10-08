package ddsutn.Business.Persona;

import ddsutn.Business.Notificacion.Notificar;
import ddsutn.Business.Persona.Persona;

import lombok.*;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "contacto")

public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellido;
	private String telefono;
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;

	@Transient
	private List<Notificar> formasDeNotificacion;

	private String formasNotificacion;

    public void recibirNotificacion(String mensaje) {
        formasDeNotificacion.forEach(formaNotificacion -> {
            try {
                formaNotificacion.notificar(this, mensaje);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void convertirFormasDeNotificacion() {
    	formasDeNotificacion.forEach(unaFormaDeNotificacion -> formasNotificacion = formasNotificacion.concat(unaFormaDeNotificacion.getClass().getSimpleName()).concat(","));
		formasNotificacion = formasNotificacion.substring(0, formasNotificacion.length()-1); // Para sacar la ultima coma que se agregue
    }

}
