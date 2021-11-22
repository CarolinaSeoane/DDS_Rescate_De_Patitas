package ddsutn.Business.Publicacion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Business.Mascota.Mascota;
import ddsutn.Business.Persona.Duenio;
import ddsutn.Business.Publicacion.Pregunta.PreguntaPublicacion;
import ddsutn.Business.Persona.Contacto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publicacion_dar_en_adopcion")
public class PublicacionDarEnAdopcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_organizacion")
	@JsonBackReference(value = "publicacion")
	private Organizacion organizacion;

	@OneToOne
	@JoinColumn(name = "id_mascota")
	private Mascota mascota;

	@OneToMany(mappedBy = "publicacion")
	@JsonManagedReference(value = "pubAdopcion")
	private Set<PreguntaPublicacion> preguntas;

	public PublicacionDarEnAdopcion(Organizacion organizacion, Mascota mascota) {
		this.organizacion = organizacion;
		this.mascota = mascota;
	}
	/*
    Si esta persona encuentra a su mascota apropiada entre las publicadas, el sistema debera notificarle
    de esta situacion, por los medios preferidos de notificacion, al actual duenio de la mascota para asi
    entablar una conversacion por fuera de la plataforma.
     */

	public void notificarDuenioSobreInteresado(Contacto contactoDelInteresado) {
		String mensaje = String.format("Hay un interesado en adoptar a %s!\nComunicarse con %s %s: Tel. %s - Email %s",
				this.mascota.getNombre(),
				contactoDelInteresado.getNombre(),
				contactoDelInteresado.getApellido(),
				contactoDelInteresado.getTelefono(),
				contactoDelInteresado.getEmail());

		Duenio duenioMascota = this.mascota.getDuenio();
		duenioMascota.notificarAMisContactos(mensaje);
	}

}