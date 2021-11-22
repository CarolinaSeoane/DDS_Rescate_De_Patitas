package ddsutn.Business.Publicacion.DTOs;

import ddsutn.Business.Mascota.DTOs.MascotaDTO;
import ddsutn.Business.Mascota.Mascota;
import ddsutn.Business.Publicacion.Pregunta.PreguntaPublicacion;
import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter

public class PubDarEnAdopcionDTO {

	MascotaDTO mascota;
	List<PreguntaPublicacionDTO> preguntas;

	public PublicacionDarEnAdopcion toPublicacionDarEnAdopcion(Mascota mascota) {
		Set<PreguntaPublicacion> preguntaPublicacion = new HashSet<>();
		for (PreguntaPublicacionDTO preg : preguntas) {
			PreguntaPublicacion pregunta = preg.toPreguntaPublicacion();
			preguntaPublicacion.add(pregunta);
		}
		return new PublicacionDarEnAdopcion(null, mascota.getOrganizacion(), mascota, preguntaPublicacion);
	}

}
