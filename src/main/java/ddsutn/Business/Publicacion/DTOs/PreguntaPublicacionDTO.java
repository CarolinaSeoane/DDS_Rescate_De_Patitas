package ddsutn.Business.Publicacion.DTOs;

import ddsutn.Business.Publicacion.Pregunta.Pregunta;
import ddsutn.Business.Publicacion.Pregunta.PreguntaPublicacion;
import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PreguntaPublicacionDTO {

	Long id;
	PreguntaPublicacion[] preguntasPublicacion;
	String pregunta;
	String respuesta;

	public PreguntaPublicacion toPreguntaPublicacion() {
		return new PreguntaPublicacion(null, null, new Pregunta(this.id, null, null, this.pregunta), this.respuesta);
	}
}
