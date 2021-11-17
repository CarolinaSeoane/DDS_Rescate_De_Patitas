package ddsutn.Seguridad.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ddsutn.Business.Persona.Duenio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue("StandardUser")

public class StandardUser extends Usuario {

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_persona_duenia")
	@JsonIgnore
	private Duenio duenioAsociado;

	public StandardUser(StandardUser body) {
		this.usuario = body.getUsuario();
		this.password = body.getPassword();
		this.duenioAsociado = body.getDuenioAsociado();
	}

}
