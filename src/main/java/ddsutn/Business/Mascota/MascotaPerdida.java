package ddsutn.Business.Mascota;

import ddsutn.Business.Hogares.Ubicacion;
import ddsutn.Business.Mascota.Foto.Foto;
import ddsutn.Business.Persona.Rescatista;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "posee_qr", discriminatorType = DiscriminatorType.STRING)
@Table(name = "mascota_perdida")

public abstract class MascotaPerdida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "mascotaPerdida", cascade = {CascadeType.ALL})
	private Set<Foto> fotos;

	@Column(name = "estado")
	private String estado;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_ubicacion")
	private Ubicacion ubicacion;

	@OneToOne
	@JoinColumn(name = "id_rescatista")
	private Rescatista rescatista;

	public MascotaPerdida(Set<Foto> foto, String estado, Ubicacion ubicacion) {
		this.fotos = foto;
		this.estado = estado;
		this.ubicacion = ubicacion;
	}

}