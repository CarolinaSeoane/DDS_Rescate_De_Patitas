package ddsutn.Business.Mascota;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ddsutn.Business.Mascota.Caracteristica.Caracteristica;
import ddsutn.Business.Mascota.Foto.Foto;
import ddsutn.Business.Organizacion.Organizacion;
import ddsutn.Business.Persona.Duenio;

import lombok.*;

import javax.persistence.*;
import java.io.IOException;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "mascota")

public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_QR")
	private String id_QR;

	@Enumerated(EnumType.STRING)
	private TipoMascota tipo;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	private String nombre;
	private String apodo;
	private int edad;
	private String descripcion;

	@OneToMany(mappedBy = "mascota", cascade = {CascadeType.ALL})
	@JsonManagedReference(value = "fotos")
	private Set<Foto> fotos;

	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(
		name = "caracteristica_X_mascota",
		joinColumns = { @JoinColumn(name = "id_mascota") },
		inverseJoinColumns = { @JoinColumn(name = "id_caracteristica") }
	)
	private Set<Caracteristica> caracteristicas;

	@ManyToOne
	@JoinColumn(name = "id_persona_duenia")
	@JsonBackReference(value = "mascotas")
	private Duenio duenio;

	@ManyToOne
	@JoinColumn(name = "id_organizacion")
	@JsonBackReference(value = "mascota")
	private Organizacion organizacion;

	public void meEncontraron() throws IOException {
        duenio.mascotaEncontrada();
    }

}
