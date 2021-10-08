package ddsutn.Business.Publicacion.Pregunta;

import ddsutn.Business.Publicacion.PublicacionDarEnAdopcion;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "preguntas_x_publicacion")

public class PreguntaPublicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_publicacion")
	private PublicacionDarEnAdopcion publicacion;

	@ManyToOne
	@JoinColumn(name = "id_pregunta")
	private Pregunta pregunta;

	@Column(name = "respuesta")
	private String respuesta;

}
