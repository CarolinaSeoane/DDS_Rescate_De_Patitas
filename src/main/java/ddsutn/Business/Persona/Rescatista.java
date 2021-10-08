package ddsutn.Business.Persona;

import ddsutn.Business.Mascota.MascotaPerdida;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue("Rescatista")

public class Rescatista extends Persona {

	@OneToOne(mappedBy = "rescatista")
	private MascotaPerdida mascotaPerdida;


	public Rescatista(TipoDcto tipoDocumento, int nroDocumento, Date fechaDeNacimiento, Contacto contacto, List<Contacto> otrosContactos, String domicilio, MascotaPerdida mascotaPerdida) {
		super(tipoDocumento, nroDocumento, fechaDeNacimiento, contacto, otrosContactos, domicilio);
		this.mascotaPerdida = mascotaPerdida;
	}

}
