package ddsutn.Business.Publicacion;

import ddsutn.Business.Persona.Contacto;
import ddsutn.Business.Notificacion.MAIL;

import lombok.*;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "publicacion_interesado")

public class PublicacionInteresado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email")
	private String emailDelInteresado;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_preferencias")
	private Preferencias preferencias;


	public void notificarAlInteresado(String mensaje) {
		MAIL notificacionMail = new MAIL();

		Contacto contactoInteresado = new Contacto();
		contactoInteresado.setEmail(this.emailDelInteresado);

		try {
			notificacionMail.notificar(contactoInteresado, mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void otorgarLinkDeBajaAlInteresado(String link) {
		this.notificarAlInteresado(link);
	}

	/* *** Recomendaciones *** */

	public void notificarRecomendacionesSemanales(List<PublicacionDarEnAdopcion> recomendaciones) {
		String mensajeRecomendaciones = "Hiciste match con las siguientes mascotas: \n";
		for(PublicacionDarEnAdopcion pub : recomendaciones) {
			String nombreMascota = pub.getMascota().getNombre();
			mensajeRecomendaciones = mensajeRecomendaciones.concat(nombreMascota+"! Mira su publicación: \n");
		}
		this.notificarAlInteresado(mensajeRecomendaciones);
	}

}
